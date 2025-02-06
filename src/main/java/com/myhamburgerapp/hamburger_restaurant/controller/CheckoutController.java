package com.myhamburgerapp.hamburger_restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String getCheckoutPage() {
        return "checkout-page";
    }
}
