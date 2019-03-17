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
}
