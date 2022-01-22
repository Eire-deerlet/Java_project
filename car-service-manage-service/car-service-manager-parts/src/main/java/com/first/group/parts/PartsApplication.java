package com.first.group.parts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.first.group.parts.mapper")
@SpringBootApplication
@ServletComponentScan("com.first.group.parts.filter")
public class PartsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PartsApplication.class, args);
    }
}
