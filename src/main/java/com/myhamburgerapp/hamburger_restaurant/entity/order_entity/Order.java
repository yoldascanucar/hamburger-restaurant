package com.myhamburgerapp.hamburger_restaurant.entity.order_entity;


import com.myhamburgerapp.hamburger_restaurant.entity.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // 1 order'da sadece 1 siparişi verilmiş hamburger olabilir.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private OrderHamburger orderHamburger;

    // 1 order'da birde fazla siparişi verilmiş içecekler olabilir.
    // Siparişi verilmiş içecekler sadece 1 order'a ait olabilir.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDrink> orderDrinks;

    // 1 order'da birde fazla siparişi verilmiş soslar olabilir.
    // Siparişi verilmiş soslar sadece 1 order'a ait olabilir.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderSauce> orderSauces;

    // 1 order'da birde fazla siparişi verilmiş sides olabilir.
    // Siparişi verilmiş sides sadece 1 order'a ait olabilir.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderSide> orderSides;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;


    public Order() {
    }

    public Order(int orderId, Customer customer, OrderHamburger orderHamburger,
                 List<OrderDrink> orderDrinks, List<OrderSauce> orderSauces,
                 List<OrderSide> orderSides, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderHamburger = orderHamburger;
        this.orderDrinks = orderDrinks;
        this.orderSauces = orderSauces;
        this.orderSides = orderSides;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderHamburger getOrderHamburger() {
        return orderHamburger;
    }

    public void setOrderHamburger(OrderHamburger orderHamburger) {
        this.orderHamburger = orderHamburger;
        if (orderHamburger != null) {
            orderHamburger.setOrder(this);
        }
    }

    public List<OrderDrink> getOrderDrinks() {
        return orderDrinks;
    }

    public void setOrderDrinks(List<OrderDrink> orderDrinks) {
        this.orderDrinks = orderDrinks;
        if (orderDrinks != null) {
            for (OrderDrink drink : orderDrinks) {
                drink.setOrder(this);
            }
        }
    }

    public List<OrderSauce> getOrderSauces() {
        return orderSauces;
    }

    public void setOrderSauces(List<OrderSauce> orderSauces) {
        this.orderSauces = orderSauces;
        if (orderSauces != null) {
            for (OrderSauce sauce : orderSauces) {
                sauce.setOrder(this);
            }
        }
    }

    public List<OrderSide> getOrderSides() {
        return orderSides;
    }

    public void setOrderSides(List<OrderSide> orderSides) {
        this.orderSides = orderSides;
        if (orderSides != null) {
            for (OrderSide side : orderSides) {
                side.setOrder(this);
            }
        }
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
