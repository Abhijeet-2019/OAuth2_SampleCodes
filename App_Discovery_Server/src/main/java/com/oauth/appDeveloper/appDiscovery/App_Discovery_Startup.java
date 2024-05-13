package com.oauth.appDeveloper.appDiscovery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class App_Discovery_Startup {
    public static void main(String[] args) {
        log.info("Starting the App Discovery Service");
        SpringApplication.run(App_Discovery_Startup.class);
        log.info("Started  the App Discovery Service");
    }
}