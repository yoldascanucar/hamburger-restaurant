package com.myhamburgerapp.hamburger_restaurant.entity.order_entity;
import com.myhamburgerapp.hamburger_restaurant.entity.Drink;
import jakarta.persistence.*;


@Entity
@Table(name = "order_drinks")
public class OrderDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false)
    private Drink drink;


    public OrderDrink() {
    }


    public OrderDrink(int id, Order order, Drink drink) {
        this.id = id;
        this.order = order;
        this.drink = drink;
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

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
