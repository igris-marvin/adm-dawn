package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    
    @GetMapping
    public String getProfile(
        Model model
    ) {
        return "profile";
    }
}
