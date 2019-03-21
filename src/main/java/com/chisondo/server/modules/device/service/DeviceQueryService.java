package com.chisondo.server.modules.device.service;

import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;

import java.util.List;
import java.util.Map;

public interface DeviceQueryService {
	
	CommonResp queryDevSettingInfo(String deviceId);

    CommonResp queryHisConnectDevOfUser(String userMobile);

	CommonResp queryMakeTeaRecordsOfDev(CommonReq req);
}
