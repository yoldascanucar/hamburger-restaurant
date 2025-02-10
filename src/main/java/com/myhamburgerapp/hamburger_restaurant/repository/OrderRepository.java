package com.myhamburgerapp.hamburger_restaurant.repository;

import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByCustomer_Id(int customerId);

    @Modifying
    @Query("DELETE FROM OrderDrink od WHERE od.order.orderId = :orderId")
    void deleteOrderDrinksByOrderId(@Param("orderId") int orderId);

    @Modifying
    @Query("DELETE FROM OrderSauce os WHERE os.order.orderId = :orderId")
    void deleteOrderSaucesByOrderId(@Param("orderId") int orderId);

    @Modifying
    @Query("DELETE FROM OrderSide os WHERE os.order.orderId = :orderId")
    void deleteOrderSidesByOrderId(@Param("orderId") int orderId);

    @Modifying
    @Query("DELETE FROM OrderHamburger oh WHERE oh.order.orderId = :orderId")
    void deleteOrderHamburgerByOrderId(@Param("orderId") int orderId);
}
