package com.myhamburgerapp.hamburger_restaurant.controller;


import com.myhamburgerapp.hamburger_restaurant.entity.HamburgerCategory;
import com.myhamburgerapp.hamburger_restaurant.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryPageController {


    private static final Logger logger = LoggerFactory.getLogger(CategoryPageController.class);


    private final CategoryService categoryService;


    @Autowired
    public CategoryPageController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/menu")
    public String getHamburgerCategories(Model model){
        List<HamburgerCategory> hamburgerCategories = categoryService.getHamburgerCategories();
        logger.debug("Tüm categories are: {}" , hamburgerCategories.stream().map(HamburgerCategory::getHamburgerCategoryName).collect(Collectors.toList()));
        model.addAttribute("hamburgerCategories", hamburgerCategories);

        return "category-list";
    }
}
