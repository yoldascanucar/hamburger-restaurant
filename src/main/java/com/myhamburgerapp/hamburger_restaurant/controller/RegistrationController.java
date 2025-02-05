package com.myhamburgerapp.hamburger_restaurant.controller;
import com.myhamburgerapp.hamburger_restaurant.config.PasswordConfig;
import com.myhamburgerapp.hamburger_restaurant.entity.Customer;
import com.myhamburgerapp.hamburger_restaurant.service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordConfig passwordConfig;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration-page";
    }

    @PostMapping("/register")
    public String handleRegistration(@Valid @ModelAttribute Customer customer, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "registration-page";
        }

        if (customerService.mailExists(customer.getCustomerMail())) {
            model.addAttribute("customer", customer);
            model.addAttribute("mailError", "This email address is already being used");
            return "registration-page";
        } else {
            String rawPassword = customer.getCustomerPassword();
            customer.setEncodedPassword(passwordConfig.passwordEncoder().encode(rawPassword));

            customerService.addCustomerToDB(customer);
            return "redirect:/login";
        }
    }
}

