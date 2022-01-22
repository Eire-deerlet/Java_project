package com.first.group.mainbody.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描全局异常处理类
 */
@Configuration
@ComponentScan("com.first.group.exception")
public class ExceptionConfig {
}
