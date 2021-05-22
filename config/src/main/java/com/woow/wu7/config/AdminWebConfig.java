package com.woow.wu7.config;

import com.woow.wu7.interceptor.MusicInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * 拦截器
 * 一. 拦截器配置过程
 *      1. 配置好拦截器需要拦截哪些请求，即编写一个拦截器实现 ( HandlerInterceptor ) 接口
 *      2. 把拦截器注册到容器中，即在 ( config ) 中实现 ( WebMvcConfigurer ) 接口的 ( addInterceptors ) 方法，方法名自定义
 *      3. 在2中的方法中指定拦截规则，注意如果是拦截所有则静态资源也会被拦截， /** 表示拦截所有
 * */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MusicInterceptor())
                .addPathPatterns("/**") // 拦截 - /**表示所有请求都被拦截，包括静态资源
                .excludePathPatterns("/login", "images/**") // 放行 - 放行登陆，静态资源中的图片，静态资源可以放在 resources/static中
        ;
    }
}
