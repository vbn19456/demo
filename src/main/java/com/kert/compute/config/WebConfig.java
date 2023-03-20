package com.kert.compute.config;

import com.kert.compute.filter.LoggerFilter;
import com.kert.compute.filter.LoginHandler;
import com.kert.compute.service.LoggerService;
import com.kert.compute.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private  LoggerService loggerService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandler(new UserServiceImpl()))
                .excludePathPatterns("/login","/flush","/error","/static/**")
                .addPathPatterns("/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/index.html").addResourceLocations("classpath:/static/");
    }

    @Bean
    public FilterRegistrationBean<LoggerFilter> b(){
        FilterRegistrationBean<LoggerFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new LoggerFilter(loggerService));
        return bean;
    }
}
