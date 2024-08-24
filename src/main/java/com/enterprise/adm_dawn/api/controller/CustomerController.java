package com.enterprise.adm_dawn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.adm_dawn.api.dto.CustomerDTO;
import com.enterprise.adm_dawn.api.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService custServ;

    // GET LIST OF EXISTING CUSTOMERS
    @GetMapping
    public String getCustomer(
        Model model
    ) {
        List<CustomerDTO> customers = custServ.getCustomersList();

        model.addAttribute("customers", customers);

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
