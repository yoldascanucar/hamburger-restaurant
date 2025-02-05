package com.myhamburgerapp.hamburger_restaurant.repository;

import com.myhamburgerapp.hamburger_restaurant.entity.Sauce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SauceRepository extends JpaRepository<Sauce, Integer> {

    List<Sauce> findAllBySauceIdIn(List<Integer> sauceIds);

    List<Sauce> findByOrderedSauces_Order_OrderId(int orderId);
}
