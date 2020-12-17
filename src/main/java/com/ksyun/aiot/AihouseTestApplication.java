package com.ksyun.aiot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ksyun.aiot.mapper")
@SpringBootApplication
public class AihouseTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AihouseTestApplication.class, args);
    }

}
