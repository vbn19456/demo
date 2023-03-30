package com.kert.compute.filter;

import com.kert.compute.model.entity.LogInfo;
import com.kert.compute.service.LoggerSer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {
    private final LoggerSer loggerService;

    public LoggerInterceptor(LoggerSer loggerService){
        this.loggerService=loggerService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        String dateFormat = format.format(date);
        makeLog(dateFormat, (ContentCachingRequestWrapper) request, (ContentCachingResponseWrapper) response);
        return true;
    }

    private void makeLog(String date,HttpServletRequest request,ContentCachingResponseWrapper response) throws IOException {
        String responseData = new String(response.getContentAsByteArray());
        LogInfo logInfo = new LogInfo();
        logInfo.setUri(request.getRequestURI());
        logInfo.setCreateTime(date);
        logInfo.setRequest(request.getInputStream().readAllBytes());
        logInfo.setResponse(responseData);
        logInfo.setClientIP(request.getRemoteAddr());
        log.info("请求：{}",logInfo);
        loggerService.insert(logInfo);
    }
}
