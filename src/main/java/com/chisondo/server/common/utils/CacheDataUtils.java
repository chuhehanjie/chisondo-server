package com.chisondo.server.common.utils;

import com.chisondo.server.modules.sys.entity.CompanyEntity;
import com.chisondo.server.modules.sys.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("cacheDataUtils")
public class CacheDataUtils {

    @Autowired
    private CompanyService companyService;

    private static List<CompanyEntity> companyList;

    @PostConstruct
    public void init() {
        companyList = this.companyService.queryList(Collections.EMPTY_MAP);
        log.info("init query companyList size = {} ", companyList.size());
    }

    public static List<CompanyEntity> getCompanyList() {
       return companyList;
    }
}
