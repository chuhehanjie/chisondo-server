package com.chisondo.server.modules.device.service;

import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.device.dto.DeviceBindReqDTO;
import com.chisondo.server.modules.device.dto.DeviceBindRespDTO;
import com.chisondo.server.modules.device.dto.MakeTeaByTeaSpectrumReqDTO;
import com.chisondo.server.modules.device.dto.StartOrReserveTeaReqDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备控制服务接口
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
public interface DeviceCtrlService {

	/**
	 * 开启或预约泡茶
	 * @param startOrReserveTeaReq
	 * @return
	 */
	@Transactional
	CommonResp startOrReserveTea(StartOrReserveTeaReqDTO startOrReserveTeaReq);

	@Transactional
    DeviceBindRespDTO bindDevice(DeviceBindReqDTO devBindReq);

	@Transactional
    void makeTeaByTeaSpectrum(MakeTeaByTeaSpectrumReqDTO makeTeaReq);
}
