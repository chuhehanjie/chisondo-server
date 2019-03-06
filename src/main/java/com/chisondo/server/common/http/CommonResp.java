package com.chisondo.server.common.http;

import java.io.Serializable;

public class CommonResp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private Integer retn;
    /**
     * 返回描述
     */
    private String desc;
    /**
     * 响应体
     * 使用json格式转换成字符串，并进行加密，形成密文,具体参数见具体接口
     */
    private String bizBody;

    public Integer getRetn() {
        return retn;
    }

    public void setRetn(Integer retn) {
        this.retn = retn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBizBody() {
        return bizBody;
    }

    public void setBizBody(String bizBody) {
        this.bizBody = bizBody;
    }
}
