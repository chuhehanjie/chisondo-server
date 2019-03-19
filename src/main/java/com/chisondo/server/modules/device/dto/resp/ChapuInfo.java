package com.chisondo.server.modules.device.dto.resp;

public class ChapuInfo {
    private int index; // 面板位置	液晶屏中的茶谱顺序
    private int chapuId; // 茶谱ID
    private String chapuName; // 茶谱名称
    private String chapuImg; // 茶谱图标	可为空，显示默认图标
    private int sortId; // 茶类ID	参考“获取茶类”接口
    private String sortName; // 茶类名称
    private int makeTimes; // 泡数	茶谱总泡数
    private String brandName; // 茶品牌名称	茶叶所属品牌

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getChapuId() {
        return chapuId;
    }

    public void setChapuId(int chapuId) {
        this.chapuId = chapuId;
    }

    public String getChapuName() {
        return chapuName;
    }

    public void setChapuName(String chapuName) {
        this.chapuName = chapuName;
    }

    public String getChapuImg() {
        return chapuImg;
    }

    public void setChapuImg(String chapuImg) {
        this.chapuImg = chapuImg;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public int getMakeTimes() {
        return makeTimes;
    }

    public void setMakeTimes(int makeTimes) {
        this.makeTimes = makeTimes;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
