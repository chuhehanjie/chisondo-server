package com.chisondo.server.modules.devctrl.service;

import com.chisondo.server.modules.devctrl.entity.DeviceTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
public interface DeviceTypeService {
	
	DeviceTypeEntity queryObject(Integer typeId);
	
	List<DeviceTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeviceTypeEntity deviceType);
	
	void update(DeviceTypeEntity deviceType);
	
	void delete(Integer typeId);
	
	void deleteBatch(Integer[] typeIds);
}
