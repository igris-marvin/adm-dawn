package com.enterprise.adm_dawn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.api.service.DashboardService;

@Controller
@RequestMapping("/")
public class DashboardController {

    @Autowired
    private DashboardService dashServ;
    
    @GetMapping
    public String getDashboard(
        Model model
    ) {
        List<CategoryDTO> categs = dashServ.getCategories();
        Integer customerSize = dashServ.getCustomerSize();

        model.addAttribute("categs", categs);
        model.addAttribute("customerSize", customerSize);

        return "index";
    }
}
