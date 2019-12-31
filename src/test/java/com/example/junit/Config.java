package com.example.junit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
@PropertySource({"classpath:test.properties"})
public class Config {
    @Resource
    private Environment environment;

    @Bean("message")
    public String getMessage(){
        return environment.getProperty("message");
    }
}
