package com.example.day21_ThymeLeaf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("another.properties")
public class HomeController {
    @GetMapping("home")     //pertains to the url on web browser
    public String home(){
        System.out.println(message);
        return "home";      //pertains to resources/templates/home.html
    }

    @Value("${another.message}")
    private String message;

}
