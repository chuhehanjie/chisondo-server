package com.chisondo.server.common.aspect;

import com.chisondo.server.common.utils.ValidateUtils;
import com.chisondo.server.modules.app.cache.AppLoginUser;
import com.chisondo.server.modules.app.cache.AppLoginUserCacheUtils;
import com.google.gson.Gson;
import com.chisondo.server.common.annotation.SysLog;
import com.chisondo.server.common.utils.HttpContextUtils;
import com.chisondo.server.common.utils.IPUtils;
import com.chisondo.server.modules.devctrl.entity.SysLogEntity;
import com.chisondo.server.modules.devctrl.entity.SysUserEntity;
import com.chisondo.server.modules.devctrl.service.SysLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * 系统日志，切面处理类
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date 2019年3月7日
 */
@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private SysLogService sysLogService;
	
	@Pointcut("@annotation(com.chisondo.server.common.annotation.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		//保存日志
		saveSysLog(point, time);

		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			//注解上的描述
			sysLog.setOperation(syslog.value());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = new Gson().toJson(args[0]);
			sysLog.setParams(params);
		}catch (Exception e){

		}

		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));


		if (ValidateUtils.isNotEmpty(SecurityUtils.getSubject()) &&
				ValidateUtils.isNotEmpty(SecurityUtils.getSubject().getPrincipal())) {
			//用户名
			String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
			sysLog.setUsername(username);
		} else {
			String openId = request.getHeader("openId");
			AppLoginUser appLoginUser = AppLoginUserCacheUtils.getAppLoginUser(openId);
			if (ValidateUtils.isNotEmpty(appLoginUser)) {
				sysLog.setUsername(appLoginUser.getUsername());
			} else {
				// 小程序没有用户 session 信息，则暂时设置默认用户名
				sysLog.setUsername("admin");
			}
		}

		sysLog.setTime(time);
		sysLog.setCreateDate(new Date());
		//保存系统日志
		sysLogService.save(sysLog);
	}
}
