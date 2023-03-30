package com.kert.compute.config;

import com.kert.compute.filter.LoggerInterceptor;
import com.kert.compute.filter.LoginInterceptor;
import com.kert.compute.filter.RequestFilter;
import com.kert.compute.service.LoggerSer;
import com.kert.compute.service.UserService;
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
    private LoggerSer loggerService;
    @Autowired
    private UserService userService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginHandler())
                .excludePathPatterns("/login","/flush","/static/**")
                .addPathPatterns("/**");
        registry.addInterceptor(getLoggerHandle()).excludePathPatterns("/login","/flush","/static/**").addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/index.html").addResourceLocations("classpath:/static/");
    }

    @Bean
    public FilterRegistrationBean<RequestFilter> b(){
        FilterRegistrationBean<RequestFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(getLogger());
        return bean;
    }

    @Bean
    public RequestFilter getLogger(){
        return new RequestFilter();
    }
    @Bean
    public LoginInterceptor getLoginHandler(){
        return new LoginInterceptor(userService);
    }
    @Bean
    public LoggerInterceptor getLoggerHandle(){
        return new LoggerInterceptor(loggerService);
    }


}
