package com.chisondo.server.modules.device.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chisondo.server.modules.device.dao.DevOnlineStatisticsDao;
import com.chisondo.server.modules.device.entity.DevOnlineStatisticsEntity;
import com.chisondo.server.modules.device.service.DevOnlineStatisticsService;



@Service("devOnlineStatisticsService")
public class DevOnlineStatisticsServiceImpl implements DevOnlineStatisticsService {
	@Autowired
	private DevOnlineStatisticsDao devOnlineStatisticsDao;
	
	@Override
	public DevOnlineStatisticsEntity queryObject(Integer rowId){
		return devOnlineStatisticsDao.queryObject(rowId);
	}
	
	@Override
	public List<DevOnlineStatisticsEntity> queryList(Map<String, Object> map){
		return devOnlineStatisticsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return devOnlineStatisticsDao.queryTotal(map);
	}
	
	@Override
	public void save(DevOnlineStatisticsEntity devOnlineStatistics){
		devOnlineStatisticsDao.save(devOnlineStatistics);
	}
	
	@Override
	public void update(DevOnlineStatisticsEntity devOnlineStatistics){
		devOnlineStatisticsDao.update(devOnlineStatistics);
	}
	
	@Override
	public void delete(Integer rowId){
		devOnlineStatisticsDao.delete(rowId);
	}
	
	@Override
	public void deleteBatch(Integer[] rowIds){
		devOnlineStatisticsDao.deleteBatch(rowIds);
	}
	
}
