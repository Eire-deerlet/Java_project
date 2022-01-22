package com.first.group.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MinIO的属性参数
 *   @ConfigurationProperties: 声明该类为属性类
 *   激活属性类的方式：
 *      1）使用@EnableConfigurationProperties(MinIOConfigProperties.class)让属性类生效（放入IOC容器）
 *      2）使用@Component直接让该属性类生效（放入IOC容器）
 */
@Data
@ConfigurationProperties(prefix = "minio") //prefix：访问前缀
public class MinIOConfigProperties {
    private String accessKey;//账户名称
    private String secretKey;//账户密码
    private String bucket;//桶名称
    private String endpoint;//MinIO连接地址   http://192.168.66.133:9000/
    private String readPath;//访问文件的地址  http://192.168.66.133:9000/
}
