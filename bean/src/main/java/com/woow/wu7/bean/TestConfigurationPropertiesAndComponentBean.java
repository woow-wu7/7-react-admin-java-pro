package com.woow.wu7.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Component + @ConfigurationProperties 两个组件配合，用来实现 ( 配置绑定 )，绑定application.properties或者application.yml文件中的变量
// @Component 把组件注册到容器中，即向IOC中添加组件 => 必须在容器中的组件，才能拥有spring提供的强大功能，即容器中的组件才能使用 @ConfigurationProperties
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component // 向IOC中添加组件
@ConfigurationProperties(prefix = "myapp") // prefix 即 application.yml中的前缀
public class TestConfigurationPropertiesAndComponentBean {
    String author;
    String email;
}
