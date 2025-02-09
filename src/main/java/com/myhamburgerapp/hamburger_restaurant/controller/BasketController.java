package com.myhamburgerapp.hamburger_restaurant.controller;
import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.*;
import com.myhamburgerapp.hamburger_restaurant.service.*;
import com.myhamburgerapp.hamburger_restaurant.user_details.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BasketController {
    private static final Logger logger = LoggerFactory.getLogger(BasketController.class);

    private final OrderService orderService;
    private final HamburgerService hamburgerService;
    private final SauceService sauceService;
    private final SideService sideService;
    private final DrinkService drinkService;

    @Autowired
    public BasketController(OrderService orderService,
                            HamburgerService hamburgerService,
                            SauceService sauceService,
                            SideService sideService,
                            DrinkService drinkService) {
       this.orderService = orderService;
       this.drinkService = drinkService;
       this.hamburgerService = hamburgerService;
       this.sideService = sideService;
       this.sauceService = sauceService;
    }

    @GetMapping("/basket")
    public String showBasket(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        int customerId = userDetails.getCustomer().getId();
        List<Order> orders = orderService.showOrderByCustomerId(customerId);

        List<Integer> orderIds = new ArrayList<>();

        for (Order order : orders) {
            orderIds.add(order.getOrderId());
        }

        Map<Integer, OrderHamburger> hamburgerDetails = hamburgerService.orderedHamburgerDetails(orderIds);
        Map<Integer, List<OrderSauce>> sauceDetails = sauceService.orderedSauceDetails(orderIds);
        Map<Integer, List<OrderSide>> sideDetails = sideService.orderedSideDetails(orderIds);
        Map<Integer, List<OrderDrink>> drinkDetails = drinkService.orderedDrinkDetails(orderIds);

        for (Order order : orders) {
            int orderId = order.getOrderId();
            order.setOrderHamburger(hamburgerDetails.get(orderId));
            order.setOrderSauces(sauceDetails.get(orderId));
            order.setOrderSides(sideDetails.get(orderId));
            order.setOrderDrinks(drinkDetails.get(orderId));
        }

        model.addAttribute("orders", orders);
        logger.info("Sipariş içinde: {}", orders.get(0));

        return "basket";
    }
}
