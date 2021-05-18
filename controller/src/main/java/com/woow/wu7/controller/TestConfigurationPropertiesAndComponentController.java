package com.woow.wu7.controller;

import com.woow.wu7.bean.TestConfigurationPropertiesAndComponentBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestConfigurationPropertiesAndComponentController {

    @Autowired
    TestConfigurationPropertiesAndComponentBean testConfigurationPropertiesAndComponentBean;

    // 测试 @Component + @ConfigurationProperties 进行配置绑定，( application.yml 和 bean )
    @GetMapping("/author")
    public TestConfigurationPropertiesAndComponentBean getAuthor() {
        log.info("测试yml文件中 ( 单引号 ) 的转义问题{}",testConfigurationPropertiesAndComponentBean.getSingleQuote());
        log.info("测试yml文件中 ( 双引号 ) 的转义问题{}",testConfigurationPropertiesAndComponentBean.getDoubleQuote());
        return testConfigurationPropertiesAndComponentBean;
    }
}
