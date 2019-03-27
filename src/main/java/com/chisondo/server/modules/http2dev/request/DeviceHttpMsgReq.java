package com.chisondo.server.modules.http2dev.request;

import com.chisondo.server.modules.device.dto.req.StartOrReserveMakeTeaReqDTO;

public class DeviceHttpMsgReq {
    private int temperature; // 数值	60-100	Y	设定的温度，需大于60度小于100度。
    private int soak; // 数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
    private int waterlevel; //固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)

    public DeviceHttpMsgReq(StartOrReserveMakeTeaReqDTO startOrReserveTeaReq) {
        this.temperature = startOrReserveTeaReq.getTemperature();
        this.soak = startOrReserveTeaReq.getSoak();
        this.waterlevel = startOrReserveTeaReq.getWaterlevel();
    }

    public DeviceHttpMsgReq() {
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getSoak() {
        return soak;
    }

    public void setSoak(int soak) {
        this.soak = soak;
    }

    public int getWaterlevel() {
        return waterlevel;
    }

    public void setWaterlevel(int waterlevel) {
        this.waterlevel = waterlevel;
    }
}
