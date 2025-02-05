package com.example.hamburger_restaurant.repository;

import com.example.hamburger_restaurant.entity.order_entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByCustomer_Id(int customerId);

    // get order detail by order id
}
