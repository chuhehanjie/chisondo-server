package com.chisondo.server.modules.devctrl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.devctrl.dao.DeviceColorDao;
import com.chisondo.server.modules.devctrl.entity.DeviceColorEntity;
import com.chisondo.server.modules.devctrl.service.DeviceColorService;



@Service("deviceColorService")
public class DeviceColorServiceImpl implements DeviceColorService {
	@Autowired
	private DeviceColorDao deviceColorDao;
	
	@Override
	public DeviceColorEntity queryObject(Integer colorId){
		return deviceColorDao.queryObject(colorId);
	}
	
	@Override
	public List<DeviceColorEntity> queryList(Map<String, Object> map){
		return deviceColorDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deviceColorDao.queryTotal(map);
	}
	
	@Override
	public void save(DeviceColorEntity deviceColor){
		deviceColorDao.save(deviceColor);
	}
	
	@Override
	public void update(DeviceColorEntity deviceColor){
		deviceColorDao.update(deviceColor);
	}
	
	@Override
	public void delete(Integer colorId){
		deviceColorDao.delete(colorId);
	}
	
	@Override
	public void deleteBatch(Integer[] colorIds){
		deviceColorDao.deleteBatch(colorIds);
	}
	
}
