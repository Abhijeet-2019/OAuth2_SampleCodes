package com.oauth.appDeveloper.resourceServer.App.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    Environment env;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port: " + env.getProperty("local.server.port");
    }
    @GetMapping("/connect")
    public String connect() {
        return "Connected on port: " + env.getProperty("local.server.port");
    }


    @GetMapping("/permitMe")
    public String permitMe() {
        return "This method is not being Authenticated: " + env.getProperty("local.server.port");
    }

}
