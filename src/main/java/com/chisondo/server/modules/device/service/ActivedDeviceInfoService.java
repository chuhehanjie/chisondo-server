package com.chisondo.server.modules.device.service;

import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 17.19
 */
public interface ActivedDeviceInfoService {
	
	ActivedDeviceInfoEntity queryObject(Integer deviceId);
	
	List<ActivedDeviceInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ActivedDeviceInfoEntity activedDeviceInfo);
	
	void update(ActivedDeviceInfoEntity activedDeviceInfo);
	
	void delete(Integer deviceId);
	
	void deleteBatch(Integer[] deviceIds);

	CommonResp queryDevSettingInfo(String deviceId);

    CommonResp queryHisConnectDevOfUser(String userMobile);

    ActivedDeviceInfoEntity getDeviceInfoById(String deviceId);
}
