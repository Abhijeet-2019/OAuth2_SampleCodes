package com.oauth.appDeveloper.CustomerDetailsResource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class CustomerResourceStartup {
    public static void main(String[] args) {
        log.info("*************Starting Customer App********************");
        SpringApplication.run(CustomerResourceStartup.class);
        log.info("*************Started Customer App********************");
    }
}