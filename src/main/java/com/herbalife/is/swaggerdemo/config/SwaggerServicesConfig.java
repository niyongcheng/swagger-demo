package com.herbalife.is.swaggerdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix="documentation.swagger")
@Data
public class SwaggerServicesConfig {
    private List<SwaggerService> services;

    @Data
    static public class SwaggerService {
        private String name;
        private String url;
        private String version;
    }
}