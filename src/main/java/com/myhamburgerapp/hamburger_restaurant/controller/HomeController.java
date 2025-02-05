package com.myhamburgerapp.hamburger_restaurant.controller;
import org.springframework.stereotype.Controller;
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
