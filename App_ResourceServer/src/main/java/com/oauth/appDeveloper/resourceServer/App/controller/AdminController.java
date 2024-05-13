package com.oauth.appDeveloper.resourceServer.App.controller;


// This is a demo Admin Controller to check if we can access
// roles

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/addUser")
    @Secured("ROLE_adminUser")
    public ResponseEntity addUser() {
        log.info("This method can add Users");
        return ResponseEntity.ok("User added Successfully");
    }

    // This method uses pre-authorize and here the method
    // is validated and executed.
    @GetMapping("deleteUsers")
    @PreAuthorize("hasRole('adminUser')")
    public ResponseEntity deleteUser(){
        log.info("This method can Delete Users");
        return ResponseEntity.ok("User Deleted  Successfully");
    }
}
