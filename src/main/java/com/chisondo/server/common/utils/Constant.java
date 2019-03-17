package com.chisondo.server.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 *
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
public class Constant {
    public static final int VERIFY_CODE_LENGTH = 4;

    public static final String SMS_SEND_OK = "OK";

    public static final String ROOT_NODE_ID = "-1";

    /**
     * 注册用户时的默认密码
     */
    public static String DEF_PWD = "123456";

    public interface ConnectState {
        /**
         * 已连接
         */
        int CONNECTED = 1;
        /**
         * 未连接
         */
        int NOT_CONNECTED = 0;
    }

    public interface RegSrc {
        String CHISONDO = "泉笙道";
    }
    public interface RegSrcType {
        String WECHAT = "微信";
    }

    /**
     * 是否为默认设备(一个用户只能有一台默认设备，一台设备可以被多个用户设置为默认设备)
     */
    public interface DevDefaultTag {
        int YES = 1;
        int NO = 0;
    }

    /**
     * 设备私有标记，1标示不允许除自己外其他人进行连接，0表示可以被其他人连接
     */
    public interface DevPrivateTag {
        int YES = 1;
        int NO = 0;
    }

    /**
     * 沏茶类型：0-茶谱沏茶；1-快速沏茶；2-面板操作
     */
    public interface MakeTeaType {
        int TEA_SPECTRUM = 0;
        int FAST = 1;
        int PANEL = 2;
    }

}
