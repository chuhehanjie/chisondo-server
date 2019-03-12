package com.chisondo.server.modules.devctrl.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
public class ActivedDeviceInfoEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer deviceId;
	//
	private String deviceName;
	//
	private Integer deviceTypeId;
	//
	private Date activedTime;
	//
	private String password;
	//
	private Integer devColor;
	//
	private String termId;
	//
	private String devDesc;
	//
	private String adminName;
	//
	private String adminPhone;
	//设备部署在餐馆的id，0表示没有关联餐馆
	private Integer restId;
	//是否锁定键盘，0没有锁定，1已经锁定
	private Integer lockPanel;

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setActivedTime(Date activedTime) {
		this.activedTime = activedTime;
	}

	public Date getActivedTime() {
		return activedTime;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public void setDevColor(Integer devColor) {
		this.devColor = devColor;
	}

	public Integer getDevColor() {
		return devColor;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermId() {
		return termId;
	}
	public void setDevDesc(String devDesc) {
		this.devDesc = devDesc;
	}

	public String getDevDesc() {
		return devDesc;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminPhone() {
		return adminPhone;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}

	public Integer getRestId() {
		return restId;
	}
	public void setLockPanel(Integer lockPanel) {
		this.lockPanel = lockPanel;
	}

	public Integer getLockPanel() {
		return lockPanel;
	}
}
