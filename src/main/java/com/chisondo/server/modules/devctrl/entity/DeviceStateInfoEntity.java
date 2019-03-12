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
public class DeviceStateInfoEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer deviceId;
	//
	private Integer onlineState;
	//
	private String deviceStateInfo;
	//
	private Integer connectState;
	//
	private Date updateTime;
	//
	private Date lastConnTime;
	//
	private Date lastValTime;
	//
	private String clientIpAddress;
	//
	private Double longitude;
	//
	private Double latitude;
	//
	private String province;
	//
	private String city;
	//
	private String district;
	//
	private String address;

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}
	public void setOnlineState(Integer onlineState) {
		this.onlineState = onlineState;
	}

	public Integer getOnlineState() {
		return onlineState;
	}
	public void setDeviceStateInfo(String deviceStateInfo) {
		this.deviceStateInfo = deviceStateInfo;
	}

	public String getDeviceStateInfo() {
		return deviceStateInfo;
	}
	public void setConnectState(Integer connectState) {
		this.connectState = connectState;
	}

	public Integer getConnectState() {
		return connectState;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setLastConnTime(Date lastConnTime) {
		this.lastConnTime = lastConnTime;
	}

	public Date getLastConnTime() {
		return lastConnTime;
	}
	public void setLastValTime(Date lastValTime) {
		this.lastValTime = lastValTime;
	}

	public Date getLastValTime() {
		return lastValTime;
	}
	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrict() {
		return district;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}
