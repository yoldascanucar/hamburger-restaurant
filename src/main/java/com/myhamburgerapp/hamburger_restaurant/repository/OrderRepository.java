package com.myhamburgerapp.hamburger_restaurant.repository;

import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByCustomer_Id(int customerId);
}
