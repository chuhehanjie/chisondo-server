package com.chisondo.server.modules.devctrl.service;

import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.devctrl.entity.StartTeaEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备控制服务接口
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date 2019年3月7日
 */
public interface DeviceCtrlService {

	/**
	 * 开启或预约泡茶
	 * @param startTeaEntity
	 * @return
	 */
	@Transactional
	CommonResp startOrReserveTea(StartTeaEntity startTeaEntity);
}
