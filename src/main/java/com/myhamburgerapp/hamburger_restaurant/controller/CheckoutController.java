package com.myhamburgerapp.hamburger_restaurant.controller;

import com.myhamburgerapp.hamburger_restaurant.util.CheckoutValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutValidation checkoutValidation;

    @GetMapping("/checkout")
    public String getCheckoutPage() {
        return "checkout-page";
    }


    @PostMapping("/checkout")
    public String handleCheckout(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName,
                                 @RequestParam(value = "phoneNumber") String phoneNumber,
                                 @RequestParam(value = "creditCardNumber") String creditCardNumber,
                                 Model model) {

      boolean isEmpty = checkoutValidation.isEmpty(firstName, lastName, phoneNumber, creditCardNumber);
      boolean isPhoneValid = checkoutValidation.isPhoneNumberValid(phoneNumber);
      boolean isCreditCardValid = checkoutValidation.isCreditCardValid(creditCardNumber);

      if (isEmpty) {
          model.addAttribute("EmptyFieldError", "Fields cannot be empty");
          logger.info("Empty Field");
          return "checkout-page";
      }

      if (!isPhoneValid) {
          model.addAttribute("InvalidPhoneNumberError","Enter a valid phone number");
          logger.info("Invalid Phone");
          return "checkout-page";
      }

      if (!isCreditCardValid) {
          model.addAttribute("InvalidCreditCardError", "Enter a valid credit card number");
          logger.info("Invalid Card");
          return "checkout-page";
      }

        return "redirect:/success?firstName=" + firstName + "&lastName=" + lastName;
    }
}
