package com.kert.compute.config;

import com.kert.compute.filter.LoggerFilter;
import com.kert.compute.service.LoggerService;
import com.kert.compute.service.impl.LoggerServiceImpl;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Autowired
    private LoggerService loggerService;

    @Bean
    public FilterRegistrationBean<LoggerFilter> b(){
        FilterRegistrationBean<LoggerFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new LoggerFilter(loggerService));
        return bean;
    }
}
