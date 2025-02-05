package com.example.hamburger_restaurant.entity;

import com.example.hamburger_restaurant.entity.order_entity.OrderDrink;
import com.example.hamburger_restaurant.entity.order_entity.OrderSide;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int drinkId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category; // "SOFT_DRINKS", "JUICES", "MILK_BASED_DRINKS", etc.

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @OneToMany(mappedBy = "drink",  cascade = CascadeType.ALL)
    private List<OrderDrink> orderedDrinks;

    public Drink() {
    }

    public Drink(int drinkId, String name, String category,
                 String description, String size, double price,
                 String imageUrl, Boolean isAvailable, List<OrderDrink> orderedDrinks) {
        this.drinkId = drinkId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.size = size;
        this.price = price;
        this.imageUrl = imageUrl;
        this.isAvailable = isAvailable;
        this.orderedDrinks = orderedDrinks;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public List<OrderDrink> getOrderedDrinks() {
        return orderedDrinks;
    }

    public void setOrderedDrinks(List<OrderDrink> orderedDrinks) {
        this.orderedDrinks = orderedDrinks;
    }
}
