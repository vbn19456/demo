package com.kert.compute.model.entity;

import lombok.Data;

@Data
public class LogInfo {
    private String uri;
    private String createTime;
    private String clientIP;
    private Object request;
    private Object response;
}
