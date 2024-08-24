package com.enterprise.adm_dawn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/browse")
public class BrowseController {

    @GetMapping("/all")
    public String getBrowse(
        Model model
    ) {
        return "browse";
    }
    
    @GetMapping("/category/{id}")
    public String getBrowseByCategoryId(
        @PathVariable("id") Long id,
        Model model
    ) {
        //get category data
        //get furniture list of the specific category

        return "browse";
    }

    @PostMapping("/search")
    public String getBrowseBySearch(
        @RequestParam("id") Long id,
        Model model
    ) {
        // search for furniture with specified ID

        String zeroMessage = 

        return "browse";
    }
}
