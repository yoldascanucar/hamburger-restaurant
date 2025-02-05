package com.example.hamburger_restaurant.repository;

import com.example.hamburger_restaurant.entity.Sauce;
import com.example.hamburger_restaurant.entity.Side;
import com.example.hamburger_restaurant.entity.order_entity.OrderSide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SideRepository extends JpaRepository<Side, Integer> {

    List<Side> findAllBySideIdIn(List<Integer> sideIds);

    List<Side> findByOrderedSides_Order_OrderId(int orderId);
}
