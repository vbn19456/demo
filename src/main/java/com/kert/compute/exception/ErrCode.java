package com.kert.compute.exception;

import lombok.Getter;

@Getter
public enum ErrCode {
    UNKNOWN_ERROR("50001","未知的错误"),
    LOGIN_ERROR("401","登录失败，账号密码错误"),
    NETWORK_ERROR("50003","网络错误");

    private final String code;
    private final String msg;
    ErrCode(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
