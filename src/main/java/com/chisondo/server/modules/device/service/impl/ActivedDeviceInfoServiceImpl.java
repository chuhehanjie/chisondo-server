package com.chisondo.server.modules.device.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.device.dao.ActivedDeviceInfoDao;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;
import com.chisondo.server.modules.device.service.ActivedDeviceInfoService;



@Service("activedDeviceInfoService")
public class ActivedDeviceInfoServiceImpl implements ActivedDeviceInfoService {
	@Autowired
	private ActivedDeviceInfoDao activedDeviceInfoDao;
	
	@Override
	public ActivedDeviceInfoEntity queryObject(Integer deviceId){
		return activedDeviceInfoDao.queryObject(deviceId);
	}
	
	@Override
	public List<ActivedDeviceInfoEntity> queryList(Map<String, Object> map){
		return activedDeviceInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return activedDeviceInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(ActivedDeviceInfoEntity activedDeviceInfo){
		activedDeviceInfoDao.save(activedDeviceInfo);
	}
	
	@Override
	public void update(ActivedDeviceInfoEntity activedDeviceInfo){
		activedDeviceInfoDao.update(activedDeviceInfo);
	}
	
	@Override
	public void delete(Integer deviceId){
		activedDeviceInfoDao.delete(deviceId);
	}
	
	@Override
	public void deleteBatch(Integer[] deviceIds){
		activedDeviceInfoDao.deleteBatch(deviceIds);
	}
	
}
