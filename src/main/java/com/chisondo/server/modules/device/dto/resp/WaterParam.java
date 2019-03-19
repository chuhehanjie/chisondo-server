package com.chisondo.server.modules.device.dto.resp;

public class WaterParam {
    private int temperature; // 设定温度
    private int soak; // 设定时间	烧水默认 0
    private int waterlevel; // 出水量	分8档

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
