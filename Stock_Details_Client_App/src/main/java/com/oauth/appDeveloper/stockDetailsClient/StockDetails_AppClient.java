package com.oauth.appDeveloper.stockDetailsClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StockDetails_AppClient {
    public static void main(String[] args) {
        SpringApplication.run(StockDetails_AppClient.class);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}