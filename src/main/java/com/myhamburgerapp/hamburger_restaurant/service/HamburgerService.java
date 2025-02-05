package com.myhamburgerapp.hamburger_restaurant.service;

import com.myhamburgerapp.hamburger_restaurant.entity.Hamburger;
import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.OrderHamburger;
import com.myhamburgerapp.hamburger_restaurant.repository.HamburgerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HamburgerService {
    private final HamburgerRepository hamburgerRepository;

    private static final Logger logger = LoggerFactory.getLogger(HamburgerService.class);

    @Autowired
    public HamburgerService(HamburgerRepository hamburgerRepository) {
        this.hamburgerRepository = hamburgerRepository;
    }

    public List<Hamburger> getHamburgersByCategoryName(String hamburgerCategory) {
        return hamburgerRepository.findByHamburgerCategory_HamburgerCategoryName(hamburgerCategory);
    }

    public Hamburger getHamburgerByHamburgerName(String hamburgerName) {
        return hamburgerRepository.findByName(hamburgerName);
    }

    public OrderHamburger getHamburgerById(int hamburgerId) {
        Hamburger hamburger = hamburgerRepository.findById(hamburgerId)
                .orElseThrow(() -> new RuntimeException("Hamburger not found"));

        OrderHamburger orderHamburger = new OrderHamburger();

        orderHamburger.setHamburger(hamburger);
        hamburger.setOrderedHamburger(orderHamburger);

        return orderHamburger;
    }

    public OrderHamburger getHamburgerByOrderId(int orderId){
        Hamburger hamburger = hamburgerRepository.findByOrderedHamburger_Order_OrderId(orderId);

        OrderHamburger orderHamburger = new OrderHamburger();
        orderHamburger.setHamburger(hamburger);
        hamburger.setOrderedHamburger(orderHamburger);

        return orderHamburger;
    }

    public Map<Integer, OrderHamburger> orderedHamburgerDetails(List<Integer> orderIds) {

        Map<Integer, OrderHamburger> orderHamburgerDetails = new HashMap<>();
        for (Integer orderId : orderIds) {
            orderHamburgerDetails.put(orderId, getHamburgerByOrderId(orderId));
        }
        return orderHamburgerDetails;
    }
}
