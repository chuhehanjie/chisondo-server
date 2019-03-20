package com.chisondo.server.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.CommonUtils;
import com.chisondo.server.common.utils.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 获取请求参数
       /* String json = CommonUtils.getJSONFromRequest(request);
        CommonReq commonReq = JSONObject.parseObject(json, CommonReq.class);
        if (null == commonReq.getReqsrc() || null == commonReq.getAcckey()
                || ValidateUtils.isEmptyString(commonReq.getTimestamp()) || ValidateUtils.isEmptyString(commonReq.getBizBody())) {
            CommonUtils.outJSONResponse(response, CommonResp.error(HttpStatus.SC_BAD_REQUEST, "错误的请求！"));
            return false;
        }*/
        // 通过该密钥+传入时间戳的第234位+ 请求来源生成鉴权字符串；规则如下：
        // acckey  =  md5（reqsrc + md5（key +  timestamp(后4位)

        return true;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        String timestamp = (System.currentTimeMillis() + "").substring(1,4);
        System.out.println(timestamp);
        String key = "XBcfMWOTUygYQFCYlvhMDmcmQNaEXWPu";
        int srcreq = 1;
        String acckey = DigestUtils.md5DigestAsHex((srcreq + DigestUtils.md5DigestAsHex((key + timestamp).getBytes())).getBytes());
        System.out.println(acckey);
        System.out.println(acckey.equalsIgnoreCase("4e8f82dc867c4f8161c6311b1fb8fa57"));
        // 4e8f82dc867c4f8161c6311b1fb8fa57
    }
}
