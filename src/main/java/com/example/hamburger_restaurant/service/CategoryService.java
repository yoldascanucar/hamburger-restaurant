package com.example.hamburger_restaurant.service;


import com.example.hamburger_restaurant.entity.HamburgerCategory;
import com.example.hamburger_restaurant.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<HamburgerCategory> getHamburgerCategories(){
        return categoryRepository.findAll();
    }
}
