package com.myhamburgerapp.hamburger_restaurant.controller;


import com.myhamburgerapp.hamburger_restaurant.entity.*;
import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.Order;
import com.myhamburgerapp.hamburger_restaurant.service.*;
import com.myhamburgerapp.hamburger_restaurant.user_details.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class OrderCustomizationPageController {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);


    @Autowired
    private HamburgerService hamburgerService;

    @Autowired
    private SauceService sauceService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private SideService sideService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/menu/{categoryName}/order/{hamburgerName}")
    public String getOrderCustomizationPage(@PathVariable String hamburgerName, Model model) {
        Hamburger hamburger  = hamburgerService.getHamburgerByHamburgerName(hamburgerName);
        List<Sauce> allSauces = sauceService.getAllSauce();
        List<Drink> allDrinks = drinkService.getAllDrinks();
        List<Side> allSides = sideService.getAllSides();

        model.addAttribute("hamburger", hamburger);

        model.addAttribute("allSauces", allSauces);
        model.addAttribute("allDrinks", allDrinks);
        model.addAttribute("allSides", allSides);
        model.addAttribute("showModal", true);
        return "order-page";
    }


    @PostMapping("/basket")
    public String handleOrderCustomizationPage(
            @RequestParam(value = "selectedHamburger") int hamburgerId,
            @RequestParam(value = "selectedSauces", required = false) List<Integer> sauceIds,
            @RequestParam(value = "selectedDrinks", required = false) List<Integer> drinkIds,
            @RequestParam(value = "selectedSides", required = false) List<Integer> sideIds,
            @RequestParam("totalPrice") BigDecimal totalPrice, Order order, HttpSession session, Authentication authentication) {

        // Log authentication status
        logger.info("Session ID: " + session.getId());
        logger.info("User ID in session: " + session.getAttribute("userId"));
        logger.info("Is user authenticated: " + (authentication != null && authentication.isAuthenticated()));

        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        // Get the authenticated user
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Customer customer = userDetails.getCustomer();

        // Set the customer on the order
        order.setCustomer(customer);

        order.setOrderHamburger(hamburgerService.getHamburgerById(hamburgerId));
        order.setOrderSauces(sauceService.getSauceById(sauceIds));
        order.setOrderDrinks(drinkService.getDrinkById(drinkIds));
        order.setOrderSides(sideService.getSideById(sideIds));
        order.setTotalPrice(totalPrice);

        orderService.saveOrderToDB(order);
        return "redirect:/";
    }
}
