package com.example.hamburger_restaurant.repository;

import com.example.hamburger_restaurant.entity.Drink;
import com.example.hamburger_restaurant.entity.Side;
import com.example.hamburger_restaurant.entity.order_entity.OrderDrink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {

    List<Drink> findAllByDrinkIdIn(List<Integer> drinkIds);

    List<Drink> findByOrderedDrinks_Order_OrderId(int orderId);
}
