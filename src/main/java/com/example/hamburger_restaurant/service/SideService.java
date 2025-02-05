package com.example.hamburger_restaurant.service;

import com.example.hamburger_restaurant.entity.Sauce;
import com.example.hamburger_restaurant.entity.Side;
import com.example.hamburger_restaurant.entity.order_entity.OrderSide;
import com.example.hamburger_restaurant.repository.SideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SideService {

    private final SideRepository sideRepository;

    @Autowired
    public SideService(SideRepository sideRepository) {
        this.sideRepository = sideRepository;
    }

    public List<Side> getAllSides() {
        return sideRepository.findAll();
    }

    public List<OrderSide> getSideById(List<Integer> sideIds) {
        List<Side> allSides = sideRepository.findAllBySideIdIn(sideIds);

        List<OrderSide> orderSides = new ArrayList<>();

        for (Side side : allSides) {
            OrderSide orderSide = new OrderSide();
            orderSide.setSide(side);
            orderSides.add(orderSide);
        }

        return orderSides;
    }

    public List<OrderSide> getSideByOrderId(int orderId) {

      List<Side> sides = sideRepository.findByOrderedSides_Order_OrderId(orderId);
      List<OrderSide> orderSides = new ArrayList<>();

      for (Side side : sides) {
          OrderSide orderSide = new OrderSide();
          orderSide.setSide(side);
          orderSides.add(orderSide);
      }
      return orderSides;
    }

    public Map<Integer, List<OrderSide>> orderedSideDetails(List<Integer> orderIds) {
        Map<Integer, List<OrderSide>> orderedSauceDetails = new HashMap<>();
        for (Integer orderId : orderIds) {
            orderedSauceDetails.put(orderId, getSideByOrderId(orderId));
        }
        return orderedSauceDetails;
    }
}
