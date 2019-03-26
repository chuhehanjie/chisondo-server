package com.chisondo.server.modules.device.service;

import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;

import java.util.List;
import java.util.Map;

public interface DeviceQueryService {
	
	CommonResp queryDevSettingInfo(String deviceId);

    CommonResp queryHisConnectDevOfUser(String userMobile);

	/**
	 * 查询设备沏茶记录
	 * @param req
	 * @return
	 */
	CommonResp queryMakeTeaRecordsOfDev(CommonReq req);

	/**
	 * 查询设备状态信息
	 * @param req
	 * @return
	 */
    CommonResp queryDevStateInfo(CommonReq req);
}
