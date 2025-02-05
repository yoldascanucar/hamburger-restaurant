package com.myhamburgerapp.hamburger_restaurant.repository;

import com.myhamburgerapp.hamburger_restaurant.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {

    List<Drink> findAllByDrinkIdIn(List<Integer> drinkIds);

    List<Drink> findByOrderedDrinks_Order_OrderId(int orderId);
}
