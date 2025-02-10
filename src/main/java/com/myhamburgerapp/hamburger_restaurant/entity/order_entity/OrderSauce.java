package com.myhamburgerapp.hamburger_restaurant.entity.order_entity;

import com.myhamburgerapp.hamburger_restaurant.entity.Sauce;
import jakarta.persistence.*;


@Entity
@Table(name = "order_sauces")
public class OrderSauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sauce_id", nullable = false)
    private Sauce sauce;

    public OrderSauce() {
    }

    public OrderSauce(int id, Order order, Sauce sauce) {
        this.id = id;
        this.order = order;
        this.sauce = sauce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }
}
