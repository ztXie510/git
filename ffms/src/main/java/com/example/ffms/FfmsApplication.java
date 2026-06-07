package com.example.ffms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ffms.dao")
public class FfmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FfmsApplication.class, args);
    }

}
