package com.rone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web拦截器配置
 *
 * @author rone
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /**
     * 默认重定向页面
     */
    private static final String REDIRECT_AUTH_LOGIN = "redirect:/auth/login";

    @Autowired
    private LoginIntercepor loginIntercepor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/media/**",
                        "/",
                        "/auth",
                        "/auth/",
                        "/*/login/**",
                        "/css/**",
                        "/fonts/**",
                        "/images/**",
                        "/js/**",
                        "/lib/**"
                );
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(REDIRECT_AUTH_LOGIN);
        registry.addViewController("/auth").setViewName(REDIRECT_AUTH_LOGIN);
        registry.addViewController("/auth/").setViewName(REDIRECT_AUTH_LOGIN);
        registry.addViewController("/*/login/**").setViewName(REDIRECT_AUTH_LOGIN);
    }
}
