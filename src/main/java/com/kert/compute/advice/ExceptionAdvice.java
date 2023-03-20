package com.kert.compute.advice;

import com.kert.compute.exception.BusinessException;
import com.kert.compute.model.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResultVO err(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        ResultVO resultVO = new ResultVO();
        resultVO.setCode("500");
        resultVO.setMessage(e.getMessage());
        return resultVO;
    }
    @ExceptionHandler(BusinessException.class)
    public ResultVO businessHandler(BusinessException e){
        log.error(e.getMessage());
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(e.getErrCode().getCode());
        resultVO.setMessage(e.getErrCode().getMsg());
        return resultVO;
    }
}
