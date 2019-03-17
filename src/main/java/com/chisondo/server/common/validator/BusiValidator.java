package com.chisondo.server.common.validator;

import com.chisondo.server.common.http.CommonReq;

public interface BusiValidator {
    boolean validate(CommonReq req);
}
