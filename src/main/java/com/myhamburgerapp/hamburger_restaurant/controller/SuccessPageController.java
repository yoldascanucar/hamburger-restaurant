package com.myhamburgerapp.hamburger_restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuccessPageController {

    @GetMapping("/success")
    public String showSuccessPage(@RequestParam(value = "firstName") String firstName,
                                  @RequestParam(value = "lastName") String lastName,
                                  Model model) {
        model.addAttribute("successMessage", firstName + " " +
                lastName + ", your purchase is successful!");

        return "success-page";
    }
}
