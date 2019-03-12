package com.chisondo.server.modules.devctrl.service;

import com.chisondo.server.modules.devctrl.entity.DeviceMoLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
public interface DeviceMoLogService {
	
	DeviceMoLogEntity queryObject(String logId);
	
	List<DeviceMoLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeviceMoLogEntity deviceMoLog);
	
	void update(DeviceMoLogEntity deviceMoLog);
	
	void delete(String logId);
	
	void deleteBatch(String[] logIds);
}
