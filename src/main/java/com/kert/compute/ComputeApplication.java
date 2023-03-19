package com.kert.compute;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kert.compute.dao")
public class ComputeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputeApplication.class, args);
    }

}
