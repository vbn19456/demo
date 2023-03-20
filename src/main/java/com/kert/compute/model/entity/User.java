package com.kert.compute.model.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String role;
}
