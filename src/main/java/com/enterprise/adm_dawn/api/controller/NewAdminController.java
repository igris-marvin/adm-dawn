package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class NewAdminController {
    
    @GetMapping
    public String getNewAdmin(
        Model model
    ) {
        return "admin";
    }

    @PostMapping
    public String postNewAdmin(
        // @ModelAttribute("admin") AdminDTO dto,
        Model model
    ) {
        return "admin_outcome";
    }
}
