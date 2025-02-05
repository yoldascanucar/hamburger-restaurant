package com.example.hamburger_restaurant.entity.order_entity;

import com.example.hamburger_restaurant.entity.Hamburger;
import jakarta.persistence.*;


@Entity
@Table(name = "order_hamburger")
public class OrderHamburger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hamburger_id", nullable = false)
    private Hamburger hamburger;

    public OrderHamburger() {
    }

    public OrderHamburger(int id, Order order, Hamburger hamburger) {
        this.id = id;
        this.order = order;
        this.hamburger = hamburger;
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

    public Hamburger getHamburger() {
        return hamburger;
    }

    public void setHamburger(Hamburger hamburger) {
        this.hamburger = hamburger;
    }
}
