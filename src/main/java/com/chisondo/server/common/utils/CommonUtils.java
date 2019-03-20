package com.chisondo.server.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ding.zhong
 * @since Mar 26.18
 */
public final class CommonUtils {
    public static Map<String, Object> buildMapByKeyValue(String [] keys, Object ... values) {
        Map<String, Object> resultMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            resultMap.put(keys[i], values[i]);
        }
        return resultMap;
    }

    public static String getCompanyNameById(Integer id) {
        // TODO 先写死，后续配成字典
        if (id == 1) {
            return "湘丰集团";
        } else if (id == 2) {
            return "静硒园";
        }
        return "泉笙道";
    }

    /**
     * 判断是否为老设备
     * @param deviceId
     * @return
     */
    public static boolean isOldDevice(String deviceId) {
        // TODO 具体判断规则待定
        return false;
    }

   /* public static String getJSONFromRequest(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int flag = 0;
        while ((flag = inputStream.read(bytes)) > 0){
            byteArrayOutputStream.write(bytes,0,flag);
        }
        return new String(byteArrayOutputStream.toByteArray(),request.getCharacterEncoding());
    }*/

    public static void outJSONResponse(HttpServletResponse response, Object obj) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSONObject.toJSONString(obj));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}
