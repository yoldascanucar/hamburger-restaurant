package com.myhamburgerapp.hamburger_restaurant.controller;

import com.myhamburgerapp.hamburger_restaurant.service.OrderService;
import com.myhamburgerapp.hamburger_restaurant.user_details.CustomUserDetails;
import com.myhamburgerapp.hamburger_restaurant.util.CheckoutValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CheckoutController {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutValidation checkoutValidation;

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String getCheckoutPage() {
        return "checkout-page";
    }


    @PostMapping("/checkout")
    public String handleCheckout(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName,
                                 @RequestParam(value = "phoneNumber") String phoneNumber,
                                 @RequestParam(value = "creditCardNumber") String creditCardNumber,
                                 RedirectAttributes redirectAttributes) {

      boolean isEmpty = checkoutValidation.isEmpty(firstName, lastName, phoneNumber, creditCardNumber);
      boolean isPhoneValid = checkoutValidation.isPhoneNumberValid(phoneNumber);
      boolean isCreditCardValid = checkoutValidation.isCreditCardValid(creditCardNumber);

      if (isEmpty) {
          redirectAttributes.addFlashAttribute("emptyFieldError", "Fields cannot be empty");
          return "redirect:/checkout";
      }

      if (!isPhoneValid) {
          redirectAttributes.addFlashAttribute("invalidPhoneNumberError","Enter a valid phone number");
          return "redirect:/checkout";
      }

      if (!isCreditCardValid) {
          redirectAttributes.addFlashAttribute("invalidCreditCardError", "Enter a valid credit card number");
          return "redirect:/checkout";
      }

      //  basketi boşaltacaksın
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        int customerId = userDetails.getCustomer().getId();

        orderService.emptyBasket(customerId);

        return "redirect:/success?firstName=" + firstName + "&lastName=" + lastName;
    }
}
