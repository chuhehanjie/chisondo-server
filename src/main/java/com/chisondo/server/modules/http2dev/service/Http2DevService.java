package com.chisondo.server.modules.http2dev.service;

import com.chisondo.server.modules.http2dev.request.DeviceHttpReq;
import com.chisondo.server.modules.http2dev.response.DeviceHttpResp;

public interface Http2DevService {
    DeviceHttpResp makeTea(DeviceHttpReq req);
}
