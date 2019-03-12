package com.chisondo.server.modules.devctrl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.devctrl.dao.DeviceMoLogDao;
import com.chisondo.server.modules.devctrl.entity.DeviceMoLogEntity;
import com.chisondo.server.modules.devctrl.service.DeviceMoLogService;



@Service("deviceMoLogService")
public class DeviceMoLogServiceImpl implements DeviceMoLogService {
	@Autowired
	private DeviceMoLogDao deviceMoLogDao;
	
	@Override
	public DeviceMoLogEntity queryObject(String logId){
		return deviceMoLogDao.queryObject(logId);
	}
	
	@Override
	public List<DeviceMoLogEntity> queryList(Map<String, Object> map){
		return deviceMoLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deviceMoLogDao.queryTotal(map);
	}
	
	@Override
	public void save(DeviceMoLogEntity deviceMoLog){
		deviceMoLogDao.save(deviceMoLog);
	}
	
	@Override
	public void update(DeviceMoLogEntity deviceMoLog){
		deviceMoLogDao.update(deviceMoLog);
	}
	
	@Override
	public void delete(String logId){
		deviceMoLogDao.delete(logId);
	}
	
	@Override
	public void deleteBatch(String[] logIds){
		deviceMoLogDao.deleteBatch(logIds);
	}
	
}
