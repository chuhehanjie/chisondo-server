package com.chisondo.server.modules.user.service;

import com.chisondo.server.modules.user.entity.UserDeviceEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
public interface UserDeviceService {
	
	UserDeviceEntity queryObject(Integer id);
	
	List<UserDeviceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserDeviceEntity userDevice);
	
	void update(UserDeviceEntity userDevice);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
