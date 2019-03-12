package com.chisondo.server.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.user.dao.UserDeviceDao;
import com.chisondo.server.modules.user.entity.UserDeviceEntity;
import com.chisondo.server.modules.user.service.UserDeviceService;



@Service("userDeviceService")
public class UserDeviceServiceImpl implements UserDeviceService {
	@Autowired
	private UserDeviceDao userDeviceDao;
	
	@Override
	public UserDeviceEntity queryObject(Integer id){
		return userDeviceDao.queryObject(id);
	}
	
	@Override
	public List<UserDeviceEntity> queryList(Map<String, Object> map){
		return userDeviceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDeviceDao.queryTotal(map);
	}
	
	@Override
	public void save(UserDeviceEntity userDevice){
		userDeviceDao.save(userDevice);
	}
	
	@Override
	public void update(UserDeviceEntity userDevice){
		userDeviceDao.update(userDevice);
	}
	
	@Override
	public void delete(Integer id){
		userDeviceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		userDeviceDao.deleteBatch(ids);
	}
	
}
