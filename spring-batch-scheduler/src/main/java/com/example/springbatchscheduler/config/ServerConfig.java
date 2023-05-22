package com.example.springbatchscheduler.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServerConfig {

    @Value("{api.server.url}")
    private String apiServerUrl;

    public String getApiServerUrl() {
        return apiServerUrl;
    }


}
