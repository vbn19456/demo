package com.kert.compute.filter;

import com.kert.compute.model.entity.LogInfo;
import com.kert.compute.service.LoggerService;
import com.kert.compute.utils.JsonUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class LoggerFilter extends OncePerRequestFilter {
    private final LoggerService loggerService;

    public LoggerFilter(LoggerService loggerService){
        this.loggerService=loggerService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("====================================================Filter");
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        String dateFormat = format.format(date);
        filterChain.doFilter(requestWrapper,responseWrapper);
        makeLog(dateFormat,requestWrapper,responseWrapper);
    }

    private void makeLog(String date,ContentCachingRequestWrapper request,ContentCachingResponseWrapper response) throws IOException {
        String requestData = new String(request.getContentAsByteArray());
        String responseData = new String(response.getContentAsByteArray());
        LogInfo logInfo = new LogInfo();
        logInfo.setUri(request.getRequestURI());
        logInfo.setCreateTime(date);
        logInfo.setRequest(requestData);
        logInfo.setResponse(responseData);
        logInfo.setClientIP(request.getRemoteAddr());
        logger.info(logInfo);
        loggerService.insert(logInfo);
        response.copyBodyToResponse();
    }
}
