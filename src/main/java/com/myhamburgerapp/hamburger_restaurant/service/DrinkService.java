package com.myhamburgerapp.hamburger_restaurant.service;

import com.myhamburgerapp.hamburger_restaurant.entity.Drink;
import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.OrderDrink;
import com.myhamburgerapp.hamburger_restaurant.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository){
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public List<OrderDrink> getDrinkById(List<Integer> drinkIds) {
        List<Drink> allDrinks = drinkRepository.findAllByDrinkIdIn(drinkIds);

        List<OrderDrink> orderDrinks = new ArrayList<>();

        for (Drink drink : allDrinks) {
           OrderDrink orderDrink = new OrderDrink();
           orderDrink.setDrink(drink);
           orderDrinks.add(orderDrink);
        }

        return orderDrinks;
    }


    public List<OrderDrink> getDrinkByOrderId(int orderId) {
        List<Drink> drinks = drinkRepository.findByOrderedDrinks_Order_OrderId(orderId);
        List<OrderDrink> orderDrinks = new ArrayList<>();

        for (Drink drink : drinks) {
            OrderDrink orderDrink = new OrderDrink();
            orderDrink.setDrink(drink);
            orderDrinks.add(orderDrink);
        }
        return orderDrinks;
    }

    public Map<Integer, List<OrderDrink>> orderedDrinkDetails(List<Integer> orderIds) {
        Map<Integer, List<OrderDrink>> orderedDrinkDetails = new HashMap<>();
        for (Integer orderId : orderIds) {
            orderedDrinkDetails.put(orderId, getDrinkByOrderId(orderId));
        }
        return orderedDrinkDetails;
    }
}
