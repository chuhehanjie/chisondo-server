package com.chisondo.server.modules.device.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.*;
import com.chisondo.server.modules.device.dto.req.DevStatusReportReq;
import com.chisondo.server.modules.device.dto.resp.DevSettingInfoResp;
import com.chisondo.server.modules.device.dto.resp.MakeTeaRespDTO;
import com.chisondo.server.modules.device.dto.resp.MakeTeaRowRespDTO;
import com.chisondo.server.modules.device.entity.DeviceStateInfoEntity;
import com.chisondo.server.modules.device.service.ActivedDeviceInfoService;
import com.chisondo.server.modules.device.service.DeviceQueryService;
import com.chisondo.server.modules.device.service.DeviceStateInfoService;
import com.chisondo.server.modules.user.service.UserMakeTeaService;
import com.google.common.collect.Maps;
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
	
	@Override
	public CommonResp queryDevSettingInfo(String deviceId) {
		/*说明	设置内置茶谱参数
		接口描述	返回洗茶按钮参数 烧水按钮参数 内置茶谱参数，是否静音等。
		请求示例
				参数列表
		key	value	参数类型	必选	备注
		action	qrydevparm	固定	Y	查询内置参数信息状态
		deviceID	898398492	可变	Y	需操作的设备ID
				响应参数
		key	value	参数类型	必选	备注
		retn	可变	Integer	Y	返回码：200表示正常，其它为异常
		desc	可变	String	Y	返回描述：返回码对应的文字说明，如：
		200-请求成功
		201-参数格式错误
		202-鉴权失败
。。。。等等，可扩展
		action	qrydevparmok 	固定	Y	请求传入的action+ok
		deviceID	898398492	可变	Y	被操作的设备ID
		msg	--	{}	Y
		state	数值	0 1 2 3	Y	状态值，可扩展
		stateinfo	数值	0 1 2 3…	Y	对应状态值的说明，如：
		0-	操作成功，非0为操作失败
		1-	其它异常错误
		volflag	1	1 2 		1-开启提示声 2-关闭提示音
		gmsflag	1	1 2		1-优先2G网络（默认）  2-优先Wi-Fi网络
		washteamsg	--	{}	Y
		temperature	数值	60-100	Y	设定的温度，需大于60度小于100度。
		soak	数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
		waterlevel	固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)
		boilwatermsg	--	{}	Y
		temperature	数值	60-100	Y	设定的温度，需大于60度小于100度。
		soak	数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
		waterlevel	固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)
		chapumsg	--	{}	Y
		index	数值	1-10	Y	面板位置
		chapuid	数值	1	Y	茶谱ID
		chapuname	茶谱名称		Y
		maketimes	总泡数		Y
		teaparm	--	{}	Y
		temperature	数值	60-100	Y	设定的温度，需大于60度小于100度。
		soak	数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
		waterlevel	固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)
*/
		DevSettingInfoResp devSettingResp = new DevSettingInfoResp();
		return CommonResp.ok(devSettingResp);
	}

	@Override
	public CommonResp queryHisConnectDevOfUser(String userMobile) {
		/*List<DeviceInfoRespDTO> devInfoList = this.activedDeviceInfoDao.queryHisConnectDevOfUserByPhone(userMobile);
		DevQueryRespDTO devQueryResp = new DevQueryRespDTO(devInfoList);
		return CommonResp.ok(devQueryResp);*/
		return CommonResp.ok();
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
			DeviceStateInfoEntity devStateInfo = CommonUtils.convert2DevStateInfo(devStatusReportReq);
			devStateInfo.setOnlineState(Constant.OnlineState.YES);
			devStateInfo.setConnectState(Constant.ConnectState.CONNECTED);
			return CommonResp.ok(devStateInfo);
		} else {
			// 从数据库中取
			DeviceStateInfoEntity devStateInfo = this.deviceStateInfoService.queryObject(deviceId);
			return CommonResp.ok(devStateInfo);
		}
	}
}
