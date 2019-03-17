package com.chisondo.server.modules.device.service.impl;
import java.util.Date;

import com.chisondo.server.common.exception.CommonException;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.*;
import com.chisondo.server.modules.device.dto.DeviceBindReqDTO;
import com.chisondo.server.modules.device.dto.DeviceBindRespDTO;
import com.chisondo.server.modules.device.dto.MakeTeaByTeaSpectrumReqDTO;
import com.chisondo.server.modules.device.dto.StartOrReserveTeaReqDTO;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;
import com.chisondo.server.modules.device.service.DeviceCtrlService;
import com.chisondo.server.modules.device.service.DeviceStateInfoService;
import com.chisondo.server.modules.user.entity.UserBookEntity;
import com.chisondo.server.modules.user.entity.UserMakeTeaEntity;
import com.chisondo.server.modules.user.entity.UserVipEntity;
import com.chisondo.server.modules.user.service.UserBookService;
import com.chisondo.server.modules.user.service.UserMakeTeaService;
import com.chisondo.server.modules.user.service.UserVipService;
import com.chisondo.server.modules.user.service.UserDeviceService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 设备控制服务实现类
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
@Slf4j
@Service("sysUserService")
public class DeviceCtrlServiceImpl implements DeviceCtrlService {

	@Autowired
	private UserVipService userVipService;

	@Autowired
	private ActivedDeviceInfoServiceImpl deviceInfoService;

	@Autowired
	private UserDeviceService userDeviceService;

	@Autowired
	private DeviceStateInfoService deviceStateInfoService;

	@Autowired
	private UserMakeTeaService userMakeTeaService;

	@Autowired
	private UserBookService userBookService;

	@Override
	public CommonResp startOrReserveTea(StartOrReserveTeaReqDTO startOrReserveTeaReq) {
		UserVipEntity user = this.userVipService.getUserByMobile(startOrReserveTeaReq.getPhoneNum());
		if (ValidateUtils.isEmpty(user)) {
			throw new CommonException("用户不存在");
		}
		int actionFlag = 1;
		boolean isReserveTea = true;
		// 是否启动泡茶
		if (this.isStartTea(startOrReserveTeaReq.getStartTime())) {
			isReserveTea = false;
		}
		// 判断是否为老设备
		if (CommonUtils.isOldDevice(startOrReserveTeaReq.getDeviceId())) {
			// TODO 调用老设备 http 请求
		} else {
			// TODO 调用新设备接口服务 小程序http -->> 设备 http -->> 设备 tcp -->> 沏茶器
			/*新设备非预约泡茶直接入4.5.3用户泡茶表；预约泡茶入4.5.4用户预约泡茶表，后端由定时程序根据预约时间自动启动泡茶信息，修改4.5.4表记录状态，
			并将泡茶信息插入4.5.3用户泡茶表；*/
			if (isReserveTea) {
				UserBookEntity userBook = new UserBookEntity();
				userBook.setTeamanId(user.getMemberId().toString());
				userBook.setDeviceId(Integer.valueOf(startOrReserveTeaReq.getDeviceId()));
				userBook.setConfigCmd("AA0B012C0F89025A023CCC"); // TODO 需要确定这个值怎么取
				userBook.setProcessTime(new Date());
				userBook.setLogTime(new Date());
				userBook.setValidFlag(0);
				userBook.setChapuId(0);
				userBook.setInformFlag(0);
				userBook.setTeaSortId(startOrReserveTeaReq.getTeaSortId());
				userBook.setTeaSortName(startOrReserveTeaReq.getTeaSortName());
				this.userBookService.save(userBook);
			} else {
				UserMakeTeaEntity userMakeTea = new UserMakeTeaEntity();
				userMakeTea.setTeamanId(user.getMemberId().toString());
				userMakeTea.setDeviceId(Integer.valueOf(startOrReserveTeaReq.getDeviceId()));
				userMakeTea.setChapuId(0);
				userMakeTea.setMaxNum(0);
				userMakeTea.setMakeIndex(0);
				userMakeTea.setAddTime(new Date());
				userMakeTea.setStatus(0);
				userMakeTea.setTemperature(startOrReserveTeaReq.getTemperature());
				userMakeTea.setWarm(0);
				userMakeTea.setSoak(startOrReserveTeaReq.getSoak());
				userMakeTea.setTeaSortId(startOrReserveTeaReq.getTeaSortId());
				userMakeTea.setTeaSortName(startOrReserveTeaReq.getTeaSortName());
				userMakeTea.setMakeType(Constant.MakeTeaType.TEA_SPECTRUM);
				userMakeTea.setBarcode("");
				userMakeTea.setDensity(0);
				this.userMakeTeaService.save(userMakeTea);
			}

		}
		// TODO 接口暂未实现 返回默认的预约号
		return CommonResp.ok(RandomStringUtils.randomAlphanumeric(20));
	}

	private boolean isStartTea(String startTime) {
		return null == startTime || DateUtils.parseDate(startTime, DateUtils.DATE_TIME_PATTERN).getTime() <= DateUtils.currentDate().getTime();
	}

	@Override
	public DeviceBindRespDTO bindDevice(DeviceBindReqDTO devBindReq) {
		// 校验设备是否存在
		ActivedDeviceInfoEntity deviceInfo = this.deviceInfoService.queryObject(Integer.valueOf(devBindReq.getDeviceId()));
		if (ValidateUtils.isEmpty(deviceInfo)) {
			throw new CommonException("设备不存在");
		}

		if (ValidateUtils.notEquals(deviceInfo.getPassword(), devBindReq.getPasswd())) {
			throw new CommonException("设备密码错误");
		}
		// 校验设备是否已经被占用(即状态为连接中)
		if (this.isDeviceConnected(devBindReq.getDeviceId())) {
			throw new CommonException("设备在连接中");
		}

		// 校验设备是否有其他用户关联，且只允许关联一个用户 privateTag = 1
		if (this.isDeviceNotAllowConnect(devBindReq.getDeviceId())) {
			throw new CommonException("设备已被占用");
		}

		// 校验

		Long userId = this.getUserId(devBindReq);

		// 保存用户与设备之间的关系
		this.userDeviceService.save(devBindReq, userId);

		// 更新设备状态信息
		this.deviceStateInfoService.saveOrUpdate(devBindReq);

		DeviceBindRespDTO devBindResp = new DeviceBindRespDTO();
		devBindResp.setDeviceId(deviceInfo.getDeviceId());
		devBindResp.setDeviceName(deviceInfo.getDeviceName());
		devBindResp.setCompanyId(deviceInfo.getCompanyId());
		devBindResp.setCompanyName(CommonUtils.getCompanyNameById(devBindReq.getCompanyId()));
		devBindResp.setDeviceDesc(deviceInfo.getDevDesc());
		return devBindResp;
	}

	private Long getUserId(DeviceBindReqDTO devBindReq) {
		Long userId = null;
		UserVipEntity user = this.userVipService.getUserByMobile(devBindReq.getPhoneNum());
		// 校验手机号是否存在
		if (ValidateUtils.isEmpty(user)) {
			// 手机号不存在则注册用户
			UserVipEntity userVip = new UserVipEntity();
			userVip.setPhone(devBindReq.getPhoneNum());
			userVip.setVipPwd(MD5Utils.encode(Constant.DEF_PWD, userVip.getPhone()));
			userVip.setRegSrcType(Constant.RegSrcType.WECHAT);
			userVip.setRegSrc(Constant.RegSrc.CHISONDO);
			userVip.setUseTag(0); // 可用标识 0：可用 1：不可用
			userVip.setIsTalent(0);
			this.userVipService.save(userVip);
			userId = userVip.getMemberId();
		} else {
			userId = user.getMemberId();
		}
		return userId;
	}

	private boolean isDeviceNotAllowConnect(String deviceId) {
		if (ValidateUtils.isNotEmptyCollection(this.userDeviceService.queryList(ImmutableMap.of(Keys.DEVICE_ID, deviceId,Keys.PRIVATE_TAG, Constant.DevPrivateTag.YES)))) {
			return true;
		}
		return false;
	}

	private boolean isDeviceConnected(String deviceId) {
		if (ValidateUtils.isNotEmptyCollection(this.deviceStateInfoService.queryList(
				ImmutableMap.of(Keys.DEVICE_ID, deviceId, Keys.CONNECT_STATE, Constant.ConnectState.CONNECTED)))) {
			return true;
		}
		return false;
	}

	@Override
	public void makeTeaByTeaSpectrum(MakeTeaByTeaSpectrumReqDTO makeTeaReq) {
		log.info("makeTeaByTeaSpectrum ok");
	}
}
