package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modify")
public class ModifyController {
    
    @GetMapping("/{id}")
    public String getModify(
        Model model
    ) {
        return "modify";
    }

    @PostMapping
    public String postModify(
        Model model
    ) {
        return "modify_outcome";
    }
}
