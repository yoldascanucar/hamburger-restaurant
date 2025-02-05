package com.example.hamburger_restaurant.repository;

import com.example.hamburger_restaurant.entity.Hamburger;
import com.example.hamburger_restaurant.entity.Sauce;
import com.example.hamburger_restaurant.entity.order_entity.OrderSauce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SauceRepository extends JpaRepository<Sauce, Integer> {

    List<Sauce> findAllBySauceIdIn(List<Integer> sauceIds);

    List<Sauce> findByOrderedSauces_Order_OrderId(int orderId);
}
