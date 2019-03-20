package com.chisondo.server.modules.device.dao;

import com.chisondo.server.modules.device.dto.resp.DeviceInfoRespDTO;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;
import com.chisondo.server.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 17.19
 */
@Mapper
public interface ActivedDeviceInfoDao extends BaseDao<ActivedDeviceInfoEntity> {

    List<DeviceInfoRespDTO> queryHisConnectDevOfUserByPhone(String userMobile);
}
