package com.kert.compute.model.vo;

import lombok.Data;

@Data
public class ResultVO {

    private String code;
    private String message;
    private Object content;
    public ResultVO(Object content){
        this.content=content;
    }
}
