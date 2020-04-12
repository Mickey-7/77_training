package com.example.day26_SpringBoot_Security.controller;

import com.example.day26_SpringBoot_Security.domain.User;
import com.example.day26_SpringBoot_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("me")
    public Principal getCurrentUser(Principal principal){
        return principal;
    }

}
