package com.chisondo.server.modules.olddevice.service.impl;

import com.chisondo.server.common.utils.RestTemplateUtils;
import com.chisondo.server.modules.olddevice.service.OldDeviceCtrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("oldDeviceCtrlService")
public class OldDeviceCtrlServiceImpl implements OldDeviceCtrlService {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @Value("chisondo.server.oldDevReqURL")
    private String oldDevReqURL;

    private void test() {
        String a = "startWorking";
    }
}
