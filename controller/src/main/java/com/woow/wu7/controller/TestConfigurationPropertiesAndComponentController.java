package com.woow.wu7.controller;

import com.woow.wu7.bean.TestConfigurationPropertiesAndComponentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigurationPropertiesAndComponentController {

    @Autowired
    TestConfigurationPropertiesAndComponentBean testConfigurationPropertiesAndComponentBean;

    // 测试 @Component + @ConfigurationProperties 进行配置绑定，( application.yml 和 bean )
    @GetMapping("/author")
    public TestConfigurationPropertiesAndComponentBean getAuthor() {
        return testConfigurationPropertiesAndComponentBean;
    }
}
