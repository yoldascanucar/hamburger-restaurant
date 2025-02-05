package com.myhamburgerapp.hamburger_restaurant.entity;
import com.myhamburgerapp.hamburger_restaurant.custom_annotation.ValidCustomerMail;
import com.myhamburgerapp.hamburger_restaurant.custom_annotation.ValidCustomerPassword;
import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name is required")
    private String customerName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name is required")
    private String customerLastName;

    @Column(name = "mail", length = 500)
    @ValidCustomerMail
    private String customerMail;

    @Column(name = "password", length = 1000)
    @ValidCustomerPassword
    private String customerPassword;

    @Transient
    private boolean isPasswordEncoded = false;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;


    public Customer() {
    }

    public Customer(int id, String customerName, String customerLastName, String customerMail,
                    String customerPassword, boolean isPasswordEncoded,
                    List<Order> orders) {
        this.id = id;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerMail = customerMail;
        this.customerPassword = customerPassword;
        this.isPasswordEncoded = isPasswordEncoded;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.customerPassword = encodedPassword;
        this.isPasswordEncoded = true;
    }

    public boolean isPasswordEncoded() {
        return isPasswordEncoded;
    }

    public void setPasswordEncoded(boolean passwordEncoded) {
        isPasswordEncoded = passwordEncoded;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerMail='" + customerMail + '\'' +
                ", customerPassword='[PROTECTED]'" + // Never output real password in toString
                '}';
    }
}
