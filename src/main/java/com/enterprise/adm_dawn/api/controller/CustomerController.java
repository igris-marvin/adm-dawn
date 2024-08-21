package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // GET LIST OF EXISTING CUSTOMERS
    @GetMapping
    public String getCustomer(
        Model model
    ) {
        return "customer";
    }

    // REMOVE CUSTOMER
    @GetMapping("/remove")
    public String removeCustomer(
        @RequestParam("id") Long id,
        Model model
    ) {
        return "customer";
    }
}
