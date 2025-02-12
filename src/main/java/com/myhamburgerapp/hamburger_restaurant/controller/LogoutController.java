package com.myhamburgerapp.hamburger_restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String handleLogout() {
        return "login";
    }
}
