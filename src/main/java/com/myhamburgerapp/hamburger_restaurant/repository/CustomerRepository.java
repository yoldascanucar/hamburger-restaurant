package com.myhamburgerapp.hamburger_restaurant.repository;

import com.myhamburgerapp.hamburger_restaurant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
     Customer findByCustomerMail(String mail);

     boolean existsByCustomerMail(String customerMail);

     // id ve order'a göre db'ye kaydetme
}
