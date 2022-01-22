package com.first.group.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始MinIO连接对象配置类
 */
@Configuration
@EnableConfigurationProperties(MinIOConfigProperties.class)
public class MinIOConfiguration {

    @Autowired
    private MinIOConfigProperties minIOConfigProperties;

    @Bean  // 固定的账号密码和访问地址生成为bean加入ioc容器
    public MinioClient createMinioClient(){
        return MinioClient.builder()
                .credentials(minIOConfigProperties.getAccessKey(),minIOConfigProperties.getSecretKey())
                .endpoint(minIOConfigProperties.getEndpoint())
                .build();

    }
}
