package com.chisondo.server.modules.olddevice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.exception.CommonException;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.utils.Constant;
import com.chisondo.server.common.utils.Keys;
import com.chisondo.server.common.utils.ParamValidatorUtils;
import com.chisondo.server.common.utils.RestTemplateUtils;
import com.chisondo.server.modules.device.dto.req.DeviceCtrlReqDTO;
import com.chisondo.server.modules.device.entity.ActivedDeviceInfoEntity;
import com.chisondo.server.modules.olddevice.req.ConnectDevReq;
import com.chisondo.server.modules.olddevice.req.MakeTeaReq;
import com.chisondo.server.modules.olddevice.resp.ConnectDevResp;
import com.chisondo.server.modules.olddevice.service.OldDeviceCtrlService;
import com.chisondo.server.modules.user.entity.UserVipEntity;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("oldDeviceCtrlService")
@Slf4j
public class OldDeviceCtrlServiceImpl implements OldDeviceCtrlService {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @Value("chisondo.server.oldDevReqURL")
    private String oldDevReqURL;

    private void test(CommonReq req, int operationType) {
        this.validate(req);
        ConnectDevResp connectDevResp = this.connectDevice(req);
        this.dispatch(connectDevResp.getSessionId(), req, operationType);
        this.disconnectDevice(connectDevResp.getSessionId());
    }

    private void disconnectDevice(String sessionId) {
        JSONObject result = this.restTemplateUtils.httpPostMediaTypeJson(this.oldDevReqURL + "disconnectDevice", JSONObject.class, ImmutableMap.of(Keys.SESSION_ID, sessionId));

    }

    private void validate(CommonReq req) {
        ParamValidatorUtils.validateByBeanId("devExistenceValidator", req);
        ParamValidatorUtils.validateByBeanId("userExistenceValidator", req);
    }

    private ConnectDevResp connectDevice(CommonReq req) {
        ConnectDevReq connectDevReq = this.buildConnectDevReq(req);
        ConnectDevResp connectDevResp = this.restTemplateUtils.httpPostMediaTypeJson(this.oldDevReqURL + "connectDevice", ConnectDevResp.class, connectDevReq);
        if (!connectDevResp.isOK()) {
            throw new CommonException(connectDevResp.getErrorInfo());
        }
        return connectDevResp;
    }

    private ConnectDevReq buildConnectDevReq(CommonReq req) {
        UserVipEntity user = (UserVipEntity) req.getAttrByKey(Keys.USER_INFO);
        ActivedDeviceInfoEntity deviceInfo = (ActivedDeviceInfoEntity) req.getAttrByKey(Keys.DEVICE_INFO);
        ConnectDevReq connectDevReq = new ConnectDevReq();
        connectDevReq.setUserId(user.getMemberId().toString());
        connectDevReq.setPhoneNum(user.getPhone());
        connectDevReq.setDeviceId(deviceInfo.getDeviceId() + "");
        connectDevReq.setPasswd(deviceInfo.getPassword());
        connectDevReq.setNeedValidate(0);
        return connectDevReq;
    }

    private void dispatch(String sessionId, CommonReq req, int operationType) {
        if (operationType == Constant.OldDeviceOperType.START_OR_RESERVE_MAKE_TEA) {
            this.doStartOrReserveMakeTea(sessionId, req);
        }
    }

    private void doStartOrReserveMakeTea(String sessionId, CommonReq req) {
        MakeTeaReq makeTeaReq = new MakeTeaReq(sessionId, JSONObject.parseObject(req.getBizBody(), DeviceCtrlReqDTO.class));
        JSONObject result = this.restTemplateUtils.httpPostMediaTypeJson(this.oldDevReqURL + "startWorking", JSONObject.class, makeTeaReq);
    }
}
