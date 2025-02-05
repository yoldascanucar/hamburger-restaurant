package com.myhamburgerapp.hamburger_restaurant.controller;
import com.myhamburgerapp.hamburger_restaurant.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("customer", new Customer());
        return "login";
    }
}
