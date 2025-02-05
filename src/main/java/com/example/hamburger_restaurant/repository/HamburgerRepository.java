package com.example.hamburger_restaurant.repository;
import com.example.hamburger_restaurant.entity.Hamburger;
import com.example.hamburger_restaurant.entity.HamburgerCategory;
import com.example.hamburger_restaurant.entity.order_entity.OrderHamburger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HamburgerRepository extends JpaRepository<Hamburger, Integer> {
    @Query(value = "SELECT h.* FROM hamburgers h " +
            "JOIN categories c ON h.category_id = c.id " +
            "WHERE c.category_name = ?1",
            nativeQuery = true)
    List<Hamburger> findByHamburgerCategory_HamburgerCategoryName(String hamburgerCategory);

    Hamburger findByName(String hamburgerName);


    // order Id'ye ilişkin hamburgeri bulma
    Hamburger findByOrderedHamburger_Order_OrderId(int orderId);
}
