package com.herbalife.is.swaggerdemo.provider;

import com.herbalife.is.swaggerdemo.config.SwaggerServicesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class PropertyResourceProvider implements SwaggerResourcesProvider {

    private final SwaggerServicesConfig config;

    @Autowired
    public PropertyResourceProvider(SwaggerServicesConfig config){
        this.config = config;
    }

    /**
     * Build and return list of Swagger Resources (i.e. each microservice api-docs info)
     */
    @Override
    public List get() {
        return config.getServices().stream().map(svc->new SwaggerResource(){{
            setName(svc.getName());
            setLocation(svc.getUrl());
            setSwaggerVersion(svc.getVersion());
        }}).collect(Collectors.toList());
    }
}
