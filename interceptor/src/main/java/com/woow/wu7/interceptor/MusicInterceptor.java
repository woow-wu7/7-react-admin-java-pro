package com.woow.wu7.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 拦截器
 * 一. 拦截器配置过程
 *      1. 配置好拦截器需要拦截哪些请求，即编写一个拦截器实现 ( HandlerInterceptor ) 接口
 *      2. 把拦截器注册到容器中，即在 ( config ) 中实现 ( WebMvcConfigurer ) 接口的 ( addInterceptors ) 方法，方法名自定义
 *      3. 在2中的方法中指定拦截规则，注意如果是拦截所有则静态资源也会被拦截， /** 表示拦截所有
 * */
@Slf4j
public class MusicInterceptor implements HandlerInterceptor {

    // preHandle 目标方法执行前，即 controller中的目标方法执行前执行preHandle
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("MusicInterceptor拦截器preHandle执行了，拦截路径是{}", requestURI);
        return HandlerInterceptor.super.preHandle(request, response, handler);
        // return true 放行
        // return false 拦截
    }

    // postHandle 目标方法执行后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // afterCompletion 页面渲染完成后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
