package com.enterprise.adm_dawn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.adm_dawn.api.dto.AdminDTO;
import com.enterprise.adm_dawn.api.service.RegisterAdminService;

@Controller
@RequestMapping("/admin")
public class RegisterAdminController {

    @Autowired
    private RegisterAdminService raServ;
    
    @GetMapping
    public String getNewAdmin(
        Model model
    ) {
        AdminDTO adm = new AdminDTO();

        model.addAttribute("adm", adm);

        return "create/register_admin";
    }

    @PostMapping
    public String postNewAdmin(
        @ModelAttribute("adm") AdminDTO dto,
        @RequestParam("re_password") String re_password,
        Model model
    ) {

        String result = raServ.registerAdmin(dto, re_password);

        model.addAttribute("result", result);

        return "outcome/register_admin_outcome";
    }
}
