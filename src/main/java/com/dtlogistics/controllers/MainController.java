package com.dtlogistics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String openMainPage() {
        return "main/login";
    }
    @GetMapping("/login")
    public String openLoginPage() {
        return "main/homePage";
    }
}
