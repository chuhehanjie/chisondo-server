package com.chisondo.server.modules.device.service;

import com.chisondo.server.modules.device.entity.DevOnlineStatisticsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
public interface DevOnlineStatisticsService {
	
	DevOnlineStatisticsEntity queryObject(Integer rowId);
	
	List<DevOnlineStatisticsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DevOnlineStatisticsEntity devOnlineStatistics);
	
	void update(DevOnlineStatisticsEntity devOnlineStatistics);
	
	void delete(Integer rowId);
	
	void deleteBatch(Integer[] rowIds);
}
