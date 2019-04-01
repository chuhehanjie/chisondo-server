package com.chisondo.server.modules.device.service.impl;
import com.chisondo.server.modules.device.dto.resp.*;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.*;
import com.chisondo.server.modules.device.dto.req.DevStatusReportReq;
import com.chisondo.server.modules.device.entity.DeviceStateInfoEntity;
import com.chisondo.server.modules.device.service.ActivedDeviceInfoService;
import com.chisondo.server.modules.device.service.DeviceQueryService;
import com.chisondo.server.modules.device.service.DeviceStateInfoService;
import com.chisondo.server.modules.http2dev.req.QryDevSettingHttpReq;
import com.chisondo.server.modules.http2dev.resp.DevSettingHttpResp;
import com.chisondo.server.modules.http2dev.service.DeviceHttpService;
import com.chisondo.server.modules.user.service.UserMakeTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("deviceQueryService")
public class DeviceQueryServiceImpl implements DeviceQueryService {
	@Autowired
	private ActivedDeviceInfoService deviceInfoService;

	@Autowired
	private UserMakeTeaService userMakeTeaService;

	@Autowired
	private DeviceStateInfoService deviceStateInfoService;

	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private DeviceHttpService deviceHttpService;
	
	@Override
	public CommonResp queryDevSettingInfo(CommonReq req) {
		ActivedDeviceInfoEntity deviceInfo = (ActivedDeviceInfoEntity) req.getAttrByKey(Keys.DEVICE_INFO);
		DevSettingRespDTO devSettingResp = new DevSettingRespDTO();

		DevSettingHttpResp httpResp = this.deviceHttpService.queryDevSettingInfo(new QryDevSettingHttpReq(req.getAttrByKey(Keys.DEVICE_ID).toString()));

		devSettingResp.setDeviceName(deviceInfo.getDeviceName());
		devSettingResp.setDevicePwd(deviceInfo.getPassword());
//		devSettingResp.setIsOpenSound(httpResp.get);
		devSettingResp.setWaterHeat(Lists.newArrayList());
		devSettingResp.setChapuInfo(Lists.newArrayList());
		return CommonResp.ok(devSettingResp);
	}

	@Override
	public CommonResp queryHisConnectDevOfUser(String userMobile) {
		List<DeviceInfoRespDTO> devInfoList = this.deviceInfoService.queryHisConnectDevOfUser(userMobile);
		DevQueryRespDTO devQueryResp = new DevQueryRespDTO(devInfoList);
		return CommonResp.ok(devQueryResp);
	}

	@Override
	public CommonResp queryMakeTeaRecordsOfDev(CommonReq req) {
		String deviceId = (String) req.getAttrByKey(Keys.DEVICE_ID);
		JSONObject jsonObj = JSONObject.parseObject(req.getBizBody());
		Map<String, Object> params = CommonUtils.getPageParams(jsonObj);
		params.put(Keys.DEVICE_ID, deviceId);
		int count = this.userMakeTeaService.countMakeTeaRecordsByDeviceId(deviceId);
		List<MakeTeaRowRespDTO> rows = this.userMakeTeaService.queryMakeTeaRecordsByDeviceId(new Query(params));
		MakeTeaRespDTO makeTeaResp = new MakeTeaRespDTO(count, rows);
		return CommonResp.ok(makeTeaResp);
	}

	@Override
	public CommonResp queryDevStateInfo(CommonReq req) {
		String deviceId = (String) req.getAttrByKey(Keys.DEVICE_ID);
		// 首先从 redis 取
		String devStateInfoStr = this.redisUtils.get(deviceId);
		if (ValidateUtils.isNotEmptyString(devStateInfoStr)) {
			DevStatusReportReq devStatusReportReq = JSONObject.parseObject(devStateInfoStr, DevStatusReportReq.class);
			DeviceStateInfoEntity devStateInfo = this.deviceStateInfoService.queryObject(deviceId);
			DevStatusRespDTO devStatusResp = CommonUtils.convert2DevStatusInfo(devStatusReportReq, devStateInfo);
			devStatusResp.setOnlineStatus(Constant.OnlineState.YES);
			devStatusResp.setConnStatus(Constant.ConnectState.CONNECTED);
			return CommonResp.ok(devStatusResp);
		} else {
			// 从数据库中取
			DeviceStateInfoEntity devStateInfo = this.deviceStateInfoService.queryObject(deviceId);
			DevStatusRespDTO devStatusResp = CommonUtils.convert2DevStatusInfo(devStateInfo);
			return CommonResp.ok(devStatusResp);
		}
	}

	@Override
	public CommonResp queryDeviceDetail(CommonReq req) {
		String deviceId = (String) req.getAttrByKey(Keys.DEVICE_ID);
		String phoneNum = (String) req.getAttrByKey(Keys.PHONE_NUM);
		List<DeviceInfoRespDTO> devInfoList = this.deviceInfoService.queryDeviceDetail(ImmutableMap.of(Keys.DEVICE_ID, deviceId, Keys.USER_MOBILE, phoneNum));
		return CommonResp.ok(devInfoList);
	}
}
