    package com.myhamburgerapp.hamburger_restaurant.entity;

    import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.OrderHamburger;
    import jakarta.persistence.*;

    @Entity
    @Table(name = "hamburgers")
    public class Hamburger {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name", nullable = false)
        private String name;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_id", nullable = false)
        private HamburgerCategory hamburgerCategory;

        @OneToOne(mappedBy = "hamburger",  cascade = CascadeType.ALL)
        private OrderHamburger orderedHamburger;

        @Column(name = "description")
        private String description;

        @Column(name = "base_price", nullable = false)
        private double basePrice;

        @Column(name = "image_url", length = 1000)
        private String imageUrl;

        @Column(name = "is_available")
        private Boolean isAvailable;

        public Hamburger() {
        }

        public Hamburger(int id, String name, HamburgerCategory hamburgerCategory,
                         OrderHamburger orderedHamburger, String description, double basePrice,
                         String imageUrl, Boolean isAvailable) {
            this.id = id;
            this.name = name;
            this.hamburgerCategory = hamburgerCategory;
            this.orderedHamburger = orderedHamburger;
            this.description = description;
            this.basePrice = basePrice;
            this.imageUrl = imageUrl;
            this.isAvailable = isAvailable;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HamburgerCategory getHamburgerCategory() {
            return hamburgerCategory;
        }

        public void setHamburgerCategory(HamburgerCategory category) {
            this.hamburgerCategory = category;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public void setBasePrice(double basePrice) {
            this.basePrice = basePrice;
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

        public OrderHamburger getOrderedHamburger() {
            return orderedHamburger;
        }

        public void setOrderedHamburger(OrderHamburger orderedHamburger) {
            this.orderedHamburger = orderedHamburger;
        }
    }
