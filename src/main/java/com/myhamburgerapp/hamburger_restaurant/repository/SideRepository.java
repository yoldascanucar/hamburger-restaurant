package com.myhamburgerapp.hamburger_restaurant.repository;

import com.myhamburgerapp.hamburger_restaurant.entity.Side;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SideRepository extends JpaRepository<Side, Integer> {

    List<Side> findAllBySideIdIn(List<Integer> sideIds);

    List<Side> findByOrderedSides_Order_OrderId(int orderId);
}
