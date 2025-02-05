package com.example.hamburger_restaurant.entity;

import com.example.hamburger_restaurant.entity.order_entity.OrderSide;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sides")
public class Side {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int sideId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category; // "FRIES", "RINGS", etc.

    @Column(name = "price")
    private double price;

    @Column(name = "size")
    private String size;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @OneToMany(mappedBy = "side",  cascade = CascadeType.ALL)
    private List<OrderSide> orderedSides;


    public Side() {
    }

    public Side(int sideId, String name, String category, double price,
                String size, String imageUrl,
                Boolean isAvailable, List<OrderSide> orderedSides) {
        this.sideId = sideId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.size = size;
        this.imageUrl = imageUrl;
        this.isAvailable = isAvailable;
        this.orderedSides = orderedSides;
    }

    public int getSideId() {
        return sideId;
    }

    public void setSideId(int sideId) {
        this.sideId = sideId;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public List<OrderSide> getOrderedSides() {
        return orderedSides;
    }

    public void setOrderedSides(List<OrderSide> orderedSides) {
        this.orderedSides = orderedSides;
    }
}
