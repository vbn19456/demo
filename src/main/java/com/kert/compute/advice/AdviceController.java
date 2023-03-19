package com.kert.compute.advice;

import com.kert.compute.model.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Slf4j
public class AdviceController implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(Exception.class)
    public void err(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResultVO resultVO = new ResultVO(body);
        resultVO.setCode("1");
        resultVO.setMessage("交互成功！！");
        return resultVO;
    }
}
