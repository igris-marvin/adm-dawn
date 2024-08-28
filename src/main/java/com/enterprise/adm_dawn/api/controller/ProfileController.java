package com.enterprise.adm_dawn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.adm_dawn.api.dto.AdminDTO;
import com.enterprise.adm_dawn.api.service.AdminService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private AdminService admServ;
    
    @GetMapping
    public String getProfile(
        // @ Authenticated user
        Model model
    ) {
        //TEST DATA
        Long id = 1L;

        AdminDTO admin = admServ.getAdminProfile(id);

        model.addAttribute("admin", admin);

        return "profile";
    }
}
