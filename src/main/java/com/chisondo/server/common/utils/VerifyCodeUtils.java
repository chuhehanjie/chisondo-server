package com.chisondo.server.common.utils;

import java.util.Random;

/**
 * @author hewei
 * @version V.1.0.0
 * @date 2019年3月7日
 */
public class VerifyCodeUtils {

    /**
     * 获取随机验证码
     *
     * @return
     */
    public static String getValidationCode(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getValidationCode(6));
    }
}
