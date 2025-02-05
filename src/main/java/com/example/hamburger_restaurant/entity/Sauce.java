package com.example.hamburger_restaurant.entity;

import com.example.hamburger_restaurant.entity.order_entity.OrderSauce;
import com.example.hamburger_restaurant.entity.order_entity.OrderSide;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sauces")
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int sauceId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @OneToMany(mappedBy = "sauce",  cascade = CascadeType.ALL)
    private List<OrderSauce> orderedSauces;

    public Sauce() {
    }

    public Sauce(int sauceId, String name, String category, double price, Boolean isAvailable, List<OrderSauce> orderedSauces) {
        this.sauceId = sauceId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.isAvailable = isAvailable;
        this.orderedSauces = orderedSauces;
    }

    public int getSauceId() {
        return sauceId;
    }

    public void setSauceId(int sauceId) {
        this.sauceId = sauceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public List<OrderSauce> getOrderedSauce() {
        return orderedSauces;
    }

    public void setOrderedSauce(List<OrderSauce> orderedSauces) {
        this.orderedSauces = orderedSauces;
    }
}
