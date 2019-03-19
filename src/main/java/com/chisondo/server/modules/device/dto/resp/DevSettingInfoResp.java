package com.chisondo.server.modules.device.dto.resp;

import java.io.Serializable;

public class DevSettingInfoResp implements Serializable {
    private String deviceName; //设备名称
    private String devicePwd; // 连接密码
    private int isOpenSound; // 是否静音	0-有提示音；1-无提音
    private WaterParam waterHeat; // 烧水参数

    private ChapuInfo chapuInfo; // 茶谱信息
}
