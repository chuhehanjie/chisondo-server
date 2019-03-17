package com.chisondo.server.modules.device.controller;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.core.AbstractController;
import com.chisondo.server.common.exception.CommonException;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.ValidateUtils;
import com.chisondo.server.modules.device.dto.DeviceBindReqDTO;
import com.chisondo.server.modules.device.dto.DeviceBindRespDTO;
import com.chisondo.server.modules.device.dto.MakeTeaByTeaSpectrumReqDTO;
import com.chisondo.server.modules.device.dto.StartOrReserveTeaReqDTO;
import com.chisondo.server.modules.device.entity.StartTeaEntity;
import com.chisondo.server.modules.device.service.DeviceCtrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备控制 controller
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
@RestController
public class DeviceCtrlController extends AbstractController {

	@Autowired
	private DeviceCtrlService deviceCtrlService;
	/**
	 * 启动或预约泡茶
	 * 设置参数并启动泡茶，或提前预约在指定的时间开始沏茶，按茶类沏茶或自己设置参数沏茶，非茶谱沏茶
	 */
	@RequestMapping("/api/rest/startWorking")
	public CommonResp startOrReserveTea(@RequestBody CommonReq req){
		StartOrReserveTeaReqDTO startOrReserveTeaReq = JSONObject.parseObject(req.getBizBody(), StartOrReserveTeaReqDTO.class);
		// TODO 校验
        return this.deviceCtrlService.startOrReserveTea(startOrReserveTeaReq);
	}

	/**
	 * 使用茶谱沏茶
	 */
	@RequestMapping("/api/rest/startByChapu")
	public CommonResp makeTeaByTeaSpectrum(@RequestBody CommonReq req){
        MakeTeaByTeaSpectrumReqDTO makeTeaReq = JSONObject.parseObject(req.getBizBody(), MakeTeaByTeaSpectrumReqDTO.class);
        this.deviceCtrlService.makeTeaByTeaSpectrum(makeTeaReq);
        return CommonResp.ok();
	}

	/**
	 * 绑定沏茶器（添加设备）
	 * @param req
	 * @return
	 */
	@RequestMapping("/api/rest/connectDevice")
	public CommonResp bindDevice(@RequestBody CommonReq req) {
		DeviceBindReqDTO devBindReq = JSONObject.parseObject(req.getBizBody(), DeviceBindReqDTO.class);
		this.validate(devBindReq);
        DeviceBindRespDTO devBindResp = this.deviceCtrlService.bindDevice(devBindReq);
		return CommonResp.ok(devBindResp);
	}

	private void validate(DeviceBindReqDTO devBindReq) {
		if (ValidateUtils.isEmptyString(devBindReq.getDeviceId())) {
			throw new CommonException("设备ID为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getPhoneNum())) {
			throw new CommonException("用户手机号为空");
		}
		if (ValidateUtils.isEmpty(devBindReq.getCompanyId())) {
			throw new CommonException("公司ID为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getLongitude())) {
			throw new CommonException("经度为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getLatitude())) {
			throw new CommonException("纬度为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getProvince())) {
			throw new CommonException("省为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getCity())) {
			throw new CommonException("市为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getDistrict())) {
			throw new CommonException("区为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getDetaddress())) {
			throw new CommonException("详细地址为空");
		}
		if (ValidateUtils.isEmptyString(devBindReq.getPasswd())) {
			throw new CommonException("密码为空");
		}
	}


}
