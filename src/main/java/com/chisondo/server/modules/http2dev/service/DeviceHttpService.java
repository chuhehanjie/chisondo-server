package com.chisondo.server.modules.http2dev.service;

import com.chisondo.server.modules.http2dev.req.DeviceHttpReq;
import com.chisondo.server.modules.http2dev.req.QryDevSettingHttpReq;
import com.chisondo.server.modules.http2dev.resp.DevSettingHttpResp;
import com.chisondo.server.modules.http2dev.resp.DeviceHttpResp;

public interface DeviceHttpService {
    DeviceHttpResp makeTea(DeviceHttpReq req);

    DevSettingHttpResp queryDevSettingInfo(QryDevSettingHttpReq req);
}
