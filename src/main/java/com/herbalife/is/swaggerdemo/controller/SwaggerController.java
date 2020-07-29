package com.herbalife.is.swaggerdemo.controller;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/api/v1")
class SwaggerController {

    private ResourceLoader resourceLoader;

    @Autowired
    SwaggerController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(path = "/swagger")
    String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping(path = "/one")
    @ResponseBody
    String returnOne() throws IOException {
        InputStream inputStream = resourceLoader.getResource("classpath:1.json").getInputStream();
        return new String(ByteStreams.toByteArray(inputStream), Charsets.UTF_8);
    }
}
