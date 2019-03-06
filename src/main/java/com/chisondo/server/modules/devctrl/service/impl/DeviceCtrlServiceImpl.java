package com.chisondo.server.modules.devctrl.service.impl;

import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.devctrl.dao.SysUserDao;
import com.chisondo.server.modules.devctrl.entity.StartTeaEntity;
import com.chisondo.server.modules.devctrl.service.DeviceCtrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 设备控制服务实现类
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date 2019年3月7日
 */
@Service("sysUserService")
public class DeviceCtrlServiceImpl implements DeviceCtrlService {
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public CommonResp startOrReserveTea(StartTeaEntity startTeaEntity) {
		// 做业务操作
		return null;
	}
}
