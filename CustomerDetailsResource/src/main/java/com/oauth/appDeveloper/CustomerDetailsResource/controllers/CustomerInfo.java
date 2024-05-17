package com.oauth.appDeveloper.CustomerDetailsResource.controllers;


import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cust")
public class CustomerInfo {

    @GetMapping("/fetchDetails")
    public String fetchAllCustomerDetails(){
        return "The Customer details are fetching";
    }
}
