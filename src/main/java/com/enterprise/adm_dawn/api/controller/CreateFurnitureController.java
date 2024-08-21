package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furniture")
public class CreateFurnitureController {
    
    @GetMapping
    public String getCreateFurniture(
        Model model
    ) {
        return "c_furniture";
    }

    @PostMapping
    public String postCreateFurniture(
        Model model
    ) {
        return "c_furniture_outcome";
    }
}
