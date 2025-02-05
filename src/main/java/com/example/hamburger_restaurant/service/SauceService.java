package com.example.hamburger_restaurant.service;


import com.example.hamburger_restaurant.entity.Hamburger;
import com.example.hamburger_restaurant.entity.Sauce;
import com.example.hamburger_restaurant.entity.order_entity.OrderSauce;
import com.example.hamburger_restaurant.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SauceService {

    private final SauceRepository sauceRepository;

    @Autowired
    public SauceService(SauceRepository sauceRepository){
        this.sauceRepository = sauceRepository;
    }

    public List<Sauce> getAllSauce() {
        return sauceRepository.findAll();
    }


    public List<OrderSauce> getSauceById(List<Integer> sauceIds) {
        // seçilmiş tüm soslar id'lerine göre çekilip sauces listine alındı
         List<Sauce> sauces = sauceRepository.findAllBySauceIdIn(sauceIds);

         // boş sipariş edilmiş soslar List'i.
         List<OrderSauce> orderSauces = new ArrayList<>();

         for (Sauce sauce : sauces) {
             OrderSauce orderSauce = new OrderSauce();
             orderSauce.setSauce(sauce);
             orderSauces.add(orderSauce);
         }


        return orderSauces;
    }


    public List<OrderSauce> getSauceByOrderId(int orderId) {
       List<Sauce> sauces = sauceRepository.findByOrderedSauces_Order_OrderId(orderId);
       List<OrderSauce> orderSauces = new ArrayList<>();

       for (Sauce sauce : sauces) {
           OrderSauce orderSauce = new OrderSauce();
           orderSauce.setSauce(sauce);
           orderSauces.add(orderSauce);
       }
      return orderSauces;
    }

    public Map<Integer, List<OrderSauce>> orderedSauceDetails(List<Integer> orderIds) {
        Map<Integer, List<OrderSauce>> orderedSauceDetails = new HashMap<>();
        for (Integer orderId : orderIds) {
            orderedSauceDetails.put(orderId, getSauceByOrderId(orderId));
        }
        return orderedSauceDetails;
    }
}
