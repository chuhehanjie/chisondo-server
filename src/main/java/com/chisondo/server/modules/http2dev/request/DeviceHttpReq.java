package com.chisondo.server.modules.http2dev.request;

import com.chisondo.server.modules.device.dto.req.StartOrReserveMakeTeaReqDTO;

import java.io.Serializable;

public class DeviceHttpReq implements Serializable {
    private static final long serialVersionUID = 1L;
    private String action;
    private int actionflag;
    private String deviceId;

    private DeviceHttpMsgReq msg;

    public DeviceHttpReq() {
    }

    public DeviceHttpReq(StartOrReserveMakeTeaReqDTO startOrReserveTeaReq) {
        this.deviceId = startOrReserveTeaReq.getDeviceId();
        this.msg = new DeviceHttpMsgReq(startOrReserveTeaReq);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getActionflag() {
        return actionflag;
    }

    public void setActionflag(int actionflag) {
        this.actionflag = actionflag;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceHttpMsgReq getMsg() {
        return msg;
    }

    public void setMsg(DeviceHttpMsgReq msg) {
        this.msg = msg;
    }
}
