package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/browse")
public class BrowseController {
    
    @GetMapping("/{id}")
    public String getBrowse(
        @PathVariable("id") Long id,
        Model model
    ) {
        //get category data
        //get furniture list of the specific category

        return "browse";
    }
}
