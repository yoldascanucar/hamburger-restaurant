package com.myhamburgerapp.hamburger_restaurant.controller;
import com.myhamburgerapp.hamburger_restaurant.entity.Hamburger;
import com.myhamburgerapp.hamburger_restaurant.service.CategoryService;
import com.myhamburgerapp.hamburger_restaurant.service.HamburgerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MenuPageController {

    private static final Logger logger = LoggerFactory.getLogger(MenuPageController.class);

    @Autowired
    private HamburgerService hamburgerService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/menu/{categoryName}")
    public String getHamburgersByCategoryName(@PathVariable String categoryName, Model model) {
        List<Hamburger> hamburgers = hamburgerService.getHamburgersByCategoryName(categoryName);
        model.addAttribute("hamburgers", hamburgers);
        return "menu";
    }
}
