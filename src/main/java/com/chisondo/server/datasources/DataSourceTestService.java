package com.chisondo.server.datasources;

import com.chisondo.server.datasources.annotation.DataSource;
import com.chisondo.server.modules.app.entity.UserEntity;
import com.chisondo.server.modules.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date 2019年3月7日
 */
@Service
public class DataSourceTestService {
    @Autowired
    private UserService userService;

    public UserEntity queryObject(Long userId){
        return userService.queryObject(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public UserEntity queryObject2(Long userId){
        return userService.queryObject(userId);
    }
}
