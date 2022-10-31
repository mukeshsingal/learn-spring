package com.learn.springrestwebclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestConfig {

    @Bean
    WebClient getClient() {
        return WebClient.create("http://localhost:9090/api/v1/employee");
    }
}
