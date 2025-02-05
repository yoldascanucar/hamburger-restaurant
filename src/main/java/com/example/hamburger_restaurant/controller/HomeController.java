package com.example.hamburger_restaurant.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "home-page";
    }


    @GetMapping("/about")
    public String aboutUs() {
        return "about-us";
    }
}
