package com.first.group;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.first.group.*.mapper", "com.first.group.mainbody.config"})
public class MainBodyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainBodyApplication.class, args);
    }
}
