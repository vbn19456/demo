package com.kert.compute.model.vo;

import lombok.Data;

@Data
public class LoginVO {
    private String token;
    private String user;
    private String pwd;
}
