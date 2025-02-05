package com.example.hamburger_restaurant.entity.order_entity;


import com.example.hamburger_restaurant.entity.Sauce;
import com.example.hamburger_restaurant.entity.Side;
import jakarta.persistence.*;

@Entity
@Table(name = "order_sides")
public class OrderSide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "side_id", nullable = false)
    private Side side;

    public OrderSide() {
    }

    public OrderSide(int id, Order order, Side side) {
        this.id = id;
        this.order = order;
        this.side = side;
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

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}
