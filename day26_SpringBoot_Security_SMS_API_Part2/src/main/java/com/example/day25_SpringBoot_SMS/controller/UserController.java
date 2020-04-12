package com.example.day25_SpringBoot_SMS.controller;

import com.example.day25_SpringBoot_SMS.domain.User;
import com.example.day25_SpringBoot_SMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("register")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("me")
    public Principal getCurrentUser(Principal principal){
        return principal;
    }
}
