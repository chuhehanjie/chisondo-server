package com.chisondo.server.common.aspect;

import com.chisondo.server.common.annotation.ParamValidator;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.utils.SpringContextUtils;
import com.chisondo.server.common.utils.ValidateUtils;
import com.chisondo.server.common.validator.BusiValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 系统日志，切面处理类
 *
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
@Aspect
@Component
public class ValidatorAspect {

	@Pointcut("@annotation(com.chisondo.server.common.annotation.ParamValidator)")
	public void validatePointCut() {
		
	}

	@Before("validatePointCut()")
	public void before(JoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();

		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		Method method = methodSignature.getMethod();
		CommonReq commonReq = (CommonReq) point.getArgs()[0];
		ParamValidator validatorAnnotation = method.getAnnotation(ParamValidator.class);
		if (ValidateUtils.isNotEmpty(validatorAnnotation)) {
			Class<? extends BusiValidator>[] validators = validatorAnnotation.value();
			for (Class<? extends BusiValidator> validator : validators) {
				BusiValidator busiValidator = SpringContextUtils.getBean(validator);
				busiValidator.validate(commonReq);
			}
		}
	}
}
