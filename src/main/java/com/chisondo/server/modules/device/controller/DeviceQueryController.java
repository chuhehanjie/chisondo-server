package com.chisondo.server.modules.device.controller;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.core.AbstractController;
import com.chisondo.server.common.exception.CommonException;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.Keys;
import com.chisondo.server.common.utils.ValidateUtils;
import com.chisondo.server.modules.device.entity.DeviceStateInfoEntity;
import com.chisondo.server.modules.device.entity.StartTeaEntity;
import com.chisondo.server.modules.device.service.ActivedDeviceInfoService;
import com.chisondo.server.modules.device.service.DeviceStateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备查询 controller
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
@RestController
public class DeviceQueryController extends AbstractController {

	@Autowired
	private DeviceStateInfoService deviceStateInfoService;

	@Autowired
	private ActivedDeviceInfoService deviceInfoService;

	/**
	 * 查询设备实时状态
	 */
	@RequestMapping("/api/rest/qryDevStatus")
	public CommonResp queryDeviceStatus(@RequestBody CommonReq req) {
		JSONObject jsonObj = JSONObject.parseObject(req.getBizBody());
		if (ValidateUtils.isEmpty(jsonObj) || ValidateUtils.isEmptyString(jsonObj.getString(Keys.DEVICE_ID))) {
			throw new CommonException("设备ID为空");
		}
		String deviceId = jsonObj.getString(Keys.DEVICE_ID);
		// TODO 直接从 redis 查询设备状态
		DeviceStateInfoEntity devStateInfo = this.deviceStateInfoService.queryObject(Integer.valueOf(deviceId));
		return CommonResp.ok(devStateInfo);
	}

	/**
	 * 查询设备设置信息
	 * @param req
	 * @return
	 */
	@RequestMapping("/api/rest/qryDeviceSetInfo")
	public CommonResp queryDevSettingInfo(@RequestBody CommonReq req) {
		JSONObject jsonObj = JSONObject.parseObject(req.getBizBody());
		if (ValidateUtils.isEmpty(jsonObj) || ValidateUtils.isEmptyString(jsonObj.getString(Keys.DEVICE_ID))) {
			throw new CommonException("设备ID为空");
		}
		/*retn	Y	Integer	返回码
		desc	Y	String	返回描述
		deviceName	Y	String	设备名称
		devicePwd	Y	String	连接密码
		isOpenSound	Y	Integer	是否静音	0-有提示音；1-无提音
		waterHeat	Y	Array	烧水参数
		temperature	Y	Integer	设定温度
		soak	Y	Integer	设定时间	烧水默认 0
		waterlevel	Y	Integer	出水量	分8档
		chapuInfo	N	Array	茶谱信息
		index	Y	Integer	面板位置	液晶屏中的茶谱顺序
		chapuId	Y	Integer	茶谱ID
		chapuName	Y	String	茶谱名称
		chapuImg	N	String	茶谱图标	可为空，显示默认图标
		sortId	Y	int	茶类ID	参考“获取茶类”接口
		sortName	Y	String	茶类名称
		makeTimes	Y	int	泡数	茶谱总泡数
		brandName	Y	String	茶品牌名称	茶叶所属品牌*/

		String deviceId = jsonObj.getString(Keys.DEVICE_ID);
		// TODO 直接从 redis 查询设备状态
		return this.deviceInfoService.queryDevSettingInfo(deviceId);
	}
}
