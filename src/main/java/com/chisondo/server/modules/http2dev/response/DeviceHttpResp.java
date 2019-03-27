package com.chisondo.server.modules.http2dev.response;

import org.apache.http.HttpStatus;

import java.io.Serializable;

public class DeviceHttpResp implements Serializable {
    /**
     * 返回码：200表示正常，其它为异常
     * 201-参数格式错误
     * 202-鉴权失败
     */
    private int retn; //

    /**
     * 返回描述：返回码对应的文字说明
     * 如： 200-请求成功 201-参数格式错误 202-鉴权失败 ......等等，可扩展
     */
    private String desc;
    /**
     * 请求传入的action+ok
     */
    private String action;
    private String deviceID;

    private DeviceHttpMsgResp msg;

    public DeviceHttpResp() {
    }

    public DeviceHttpResp(int retn, String desc) {
        this.retn = retn;
        this.desc = desc;
    }

    public int getRetn() {
        return retn;
    }

    public void setRetn(int retn) {
        this.retn = retn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public DeviceHttpMsgResp getMsg() {
        return msg;
    }

    public void setMsg(DeviceHttpMsgResp msg) {
        this.msg = msg;
    }

    public boolean isOK() {
        return this.retn == HttpStatus.SC_OK;
    }
}
