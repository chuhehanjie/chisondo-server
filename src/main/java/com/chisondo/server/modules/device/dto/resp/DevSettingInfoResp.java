package com.chisondo.server.modules.device.dto.resp;

import java.io.Serializable;

public class DevSettingInfoResp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String deviceName; //设备名称
    private String devicePwd; // 连接密码
    private int isOpenSound; // 是否静音	0-有提示音；1-无提音
    private WaterParam waterHeat; // 烧水参数

    private ChapuInfo chapuInfo; // 茶谱信息

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDevicePwd() {
        return devicePwd;
    }

    public void setDevicePwd(String devicePwd) {
        this.devicePwd = devicePwd;
    }

    public int getIsOpenSound() {
        return isOpenSound;
    }

    public void setIsOpenSound(int isOpenSound) {
        this.isOpenSound = isOpenSound;
    }

    public WaterParam getWaterHeat() {
        return waterHeat;
    }

    public void setWaterHeat(WaterParam waterHeat) {
        this.waterHeat = waterHeat;
    }

    public ChapuInfo getChapuInfo() {
        return chapuInfo;
    }

    public void setChapuInfo(ChapuInfo chapuInfo) {
        this.chapuInfo = chapuInfo;
    }
}
