package com.myhamburgerapp.hamburger_restaurant.repository;
import com.myhamburgerapp.hamburger_restaurant.entity.HamburgerCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<HamburgerCategory, Integer> {

}
