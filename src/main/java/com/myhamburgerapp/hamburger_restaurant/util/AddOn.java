package com.myhamburgerapp.hamburger_restaurant.util;

public enum AddOn {
    // Meat Add-Ons
    EXTRA_BEEF_PATTY("Extra Beef Patty", 50.00),
    GRILLED_CHICKEN("Extra Grilled Chicken", 25.00),
    CRISPY_CHICKEN("Extra Crispy Chicken", 25.00),
    BACON_STRIPS("Bacon Strips", 15.00),

    // Cheese Add-Ons
    EXTRA_CHEESE("Extra Cheese", 10.00),
    BLUE_CHEESE("Blue Cheese", 15.00),
    SWISS_CHEESE("Swiss Cheese", 12.00),
    FETA_CHEESE("Feta Cheese", 12.00),
    MOZZARELLA("Mozzarella", 10.00),
    PECORINO_ROMANO("Pecorino Romano", 18.00),

    // Vegetable Add-Ons
    AVOCADO_SLICE("Avocado Slice", 12.00),
    ROASTED_RED_PEPPERS("Roasted Red Peppers", 8.00),
    CARAMELIZED_ONIONS("Caramelized Onions", 9.00),
    JALAPENOS("Jalapeños", 5.00),
    SAUTEED_MUSHROOMS("Sautéed Mushrooms", 10.00),

    // Premium Add-Ons
    TRUFFLE_SHAVINGS("Black Truffle Shavings", 45.00),
    FOIE_GRAS("Foie Gras", 75.00);

    private final String description;
    private final double price;

    AddOn(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
