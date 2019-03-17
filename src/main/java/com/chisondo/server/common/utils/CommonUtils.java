package com.chisondo.server.common.utils;

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
}
