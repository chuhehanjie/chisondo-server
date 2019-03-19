package com.chisondo.server.modules.device.service.impl;
import java.util.Date;

import com.chisondo.server.common.utils.ValidateUtils;
import com.chisondo.server.modules.device.dto.req.DeviceBindReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.device.dao.DeviceStateInfoDao;
import com.chisondo.server.modules.device.entity.DeviceStateInfoEntity;
import com.chisondo.server.modules.device.service.DeviceStateInfoService;



@Service("deviceStateInfoService")
public class DeviceStateInfoServiceImpl implements DeviceStateInfoService {
	@Autowired
	private DeviceStateInfoDao deviceStateInfoDao;
	
	@Override
	public DeviceStateInfoEntity queryObject(Integer deviceId){
		return deviceStateInfoDao.queryObject(deviceId);
	}
	
	@Override
	public List<DeviceStateInfoEntity> queryList(Map<String, Object> map){
		return deviceStateInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deviceStateInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(DeviceStateInfoEntity deviceStateInfo){
		deviceStateInfoDao.save(deviceStateInfo);
	}
	
	@Override
	public void update(DeviceStateInfoEntity deviceStateInfo){
		deviceStateInfoDao.update(deviceStateInfo);
	}
	
	@Override
	public void delete(Integer deviceId){
		deviceStateInfoDao.delete(deviceId);
	}
	
	@Override
	public void deleteBatch(Integer[] deviceIds){
		deviceStateInfoDao.deleteBatch(deviceIds);
	}

	@Override
	public void saveOrUpdate(DeviceBindReqDTO devBindReq) {
		DeviceStateInfoEntity devStateInfo = this.queryObject(Integer.valueOf(devBindReq.getDeviceId()));
		if (ValidateUtils.isEmpty(devStateInfo)) {
			devStateInfo = new DeviceStateInfoEntity();
			this.setDevStateAttrs(devBindReq, devStateInfo);
			this.save(devStateInfo);
		} else {
			this.setDevStateAttrs(devBindReq, devStateInfo);
			this.update(devStateInfo);
		}
	}

	private void setDevStateAttrs(DeviceBindReqDTO devBindReq, DeviceStateInfoEntity devStateInfo) {
		devStateInfo.setDeviceId(Integer.valueOf(devBindReq.getDeviceId()));
		devStateInfo.setUpdateTime(new Date());
		devStateInfo.setLongitude(Double.valueOf(devBindReq.getLongitude()));
		devStateInfo.setLatitude(Double.valueOf(devBindReq.getLatitude()));
		devStateInfo.setProvince(devBindReq.getProvince());
		devStateInfo.setCity(devBindReq.getCity());
		devStateInfo.setDistrict(devBindReq.getDistrict());
		devStateInfo.setAddress(devBindReq.getDetaddress());
	}
}
