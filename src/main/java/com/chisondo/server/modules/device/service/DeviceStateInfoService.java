package com.chisondo.server.modules.device.service;

import com.chisondo.server.modules.device.dto.DeviceBindReqDTO;
import com.chisondo.server.modules.device.entity.DeviceStateInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 17.19
 */
public interface DeviceStateInfoService {
	
	DeviceStateInfoEntity queryObject(Integer deviceId);
	
	List<DeviceStateInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeviceStateInfoEntity deviceStateInfo);
	
	void update(DeviceStateInfoEntity deviceStateInfo);
	
	void delete(Integer deviceId);
	
	void deleteBatch(Integer[] deviceIds);

    void saveOrUpdate(DeviceBindReqDTO devBindReq);
}