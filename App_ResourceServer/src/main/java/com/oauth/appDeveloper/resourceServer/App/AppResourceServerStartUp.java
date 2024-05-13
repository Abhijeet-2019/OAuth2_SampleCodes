package com.oauth.appDeveloper.resourceServer.App;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class AppResourceServerStartUp {

    public static void main(String[] args) {
        log.info(" ---Starting the  App Developer Resource Server App---");
        SpringApplication.run(AppResourceServerStartUp.class);
        log.info(" ---Started the Server---");
    }
}
