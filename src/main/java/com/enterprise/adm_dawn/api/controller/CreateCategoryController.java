package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CreateCategoryController {
    
    @GetMapping
    public String getCreateCategory(
        Model model
    ) {
        return "c_category";
    }

    @PostMapping
    public String postCreateCategory(
        // @ModelAttribute("category") CategoryDTO dto,
        Model model
    ) {
        return "c_category_outcome";
    }
}
