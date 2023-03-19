package com.kert.compute.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrCode errCode;
    public BusinessException(ErrCode errCode){
        this.errCode=errCode;
    }
}
