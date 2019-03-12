package com.chisondo.server.modules.devctrl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.devctrl.dao.DeviceTypeDao;
import com.chisondo.server.modules.devctrl.entity.DeviceTypeEntity;
import com.chisondo.server.modules.devctrl.service.DeviceTypeService;



@Service("deviceTypeService")
public class DeviceTypeServiceImpl implements DeviceTypeService {
	@Autowired
	private DeviceTypeDao deviceTypeDao;
	
	@Override
	public DeviceTypeEntity queryObject(Integer typeId){
		return deviceTypeDao.queryObject(typeId);
	}
	
	@Override
	public List<DeviceTypeEntity> queryList(Map<String, Object> map){
		return deviceTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deviceTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(DeviceTypeEntity deviceType){
		deviceTypeDao.save(deviceType);
	}
	
	@Override
	public void update(DeviceTypeEntity deviceType){
		deviceTypeDao.update(deviceType);
	}
	
	@Override
	public void delete(Integer typeId){
		deviceTypeDao.delete(typeId);
	}
	
	@Override
	public void deleteBatch(Integer[] typeIds){
		deviceTypeDao.deleteBatch(typeIds);
	}
	
}
