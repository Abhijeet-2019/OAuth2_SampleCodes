package com.oauth.appDeveloper.apiGateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class App_ApiGateWayStartUp {

    public static void main(String[] args) {
        log.info("-----Starting the App Api Gateway------");
        SpringApplication.run(App_ApiGateWayStartUp.class);
        log.info("-----Started the App Api Gateway------");
    }
}
