package com.kert.compute.exception;

import lombok.Getter;

@Getter
public enum ErrCode {
    UNKNOWN_ERROR("未知的错误"),
    NETWORK_ERROR("网络错误");

    private final String msg;
    ErrCode(String msg){
        this.msg=msg;
    }

}
