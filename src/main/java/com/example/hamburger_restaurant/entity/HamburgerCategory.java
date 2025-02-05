package com.example.hamburger_restaurant.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class HamburgerCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String hamburgerCategoryName;

    @Column(name = "cover_url")
    private String coverUrl;

    @OneToMany(mappedBy = "hamburgerCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hamburger> hamburgers;

    public HamburgerCategory() {
    }

    public HamburgerCategory(int id, String hamburgerCategoryName, String coverUrl) {
        this.id = id;
        this.hamburgerCategoryName = hamburgerCategoryName;
        this.coverUrl = coverUrl;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHamburgerCategoryName() {
        return hamburgerCategoryName;
    }

    public void setHamburgerCategoryName(String hamburgerCategoryName) {
        this.hamburgerCategoryName = hamburgerCategoryName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<Hamburger> getHamburgers() {
        return hamburgers;
    }

    public void setHamburgers(List<Hamburger> hamburgers) {
        this.hamburgers = hamburgers;
    }

}
