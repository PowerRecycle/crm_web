package com.crazycode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.crazycode.mapper")
public class CrmWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmWebApplication.class, args);
    }
}

