package com.example.hamburger_restaurant.repository;
import com.example.hamburger_restaurant.entity.HamburgerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<HamburgerCategory, Integer> {

}
