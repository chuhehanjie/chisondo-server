package com.chisondo.server.common.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("cacheDataUtils")
public class CacheDataUtils {


    @PostConstruct
    public void init() {
       /* this.dataDictList = this.sysDataDictService.queryList(Collections.EMPTY_MAP);
        System.out.println("dataDictList size = " + dataDictList.size());
        this.configList = this.sysConfigService.queryAll();
        System.out.println("configList size = " + configList.size());*/
    }


    /*public List<SysDataDictEntity> getDataDictList() {
        return this.dataDictList;
    }

    public List<SysConfigEntity> getConfigList() {
        return configList;
    }

    public String getConfigValueByKey(String key) {
        if (ValidateUtils.isNotEmptyCollection(this.configList)) {
            SysConfigEntity config = this.configList.stream().filter(item -> ValidateUtils.equals(key, item.getKey())).findFirst().orElse(null);
            return ValidateUtils.isNotEmpty(config) ? config.getValue() : null;
        }
        return null;
    }*/
}
