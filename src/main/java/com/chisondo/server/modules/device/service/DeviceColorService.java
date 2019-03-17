package com.chisondo.server.modules.device.service;

import com.chisondo.server.modules.device.entity.DeviceColorEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
public interface DeviceColorService {
	
	DeviceColorEntity queryObject(Integer colorId);
	
	List<DeviceColorEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeviceColorEntity deviceColor);
	
	void update(DeviceColorEntity deviceColor);
	
	void delete(Integer colorId);
	
	void deleteBatch(Integer[] colorIds);
}
