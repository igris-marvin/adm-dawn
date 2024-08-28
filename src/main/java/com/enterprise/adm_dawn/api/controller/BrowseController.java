package com.enterprise.adm_dawn.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.api.service.BrowseService;

@Controller
@RequestMapping("/browse")
public class BrowseController {

    @Autowired
    private BrowseService brosServ;

    @GetMapping
    public String getBrowse(
        Model model
    ) {
        List<FurnitureDTO> furniture = brosServ.getFurniture();

        String message = "No existing furniture found, please publish furniture!";

        model.addAttribute("heading", "Furniture");
        model.addAttribute("furniture", furniture);
        model.addAttribute("message", message);

        return "browse";
    }
    
    @GetMapping("/category/{id}")
    public String getBrowseByCategoryId(
        @PathVariable("id") Long id,
        Model model
    ) {
        CategoryDTO dto = brosServ.getCategory(id);
        List<FurnitureDTO> furniture = brosServ.getFurnitureByCategory(id);

        String catName = dto == null ? "---" : dto.getCategoryName();
        String message = "No existing furniture found under the requested category!";

        model.addAttribute("heading", "Furniture By Category: " + catName);
        model.addAttribute("furniture", furniture);
        model.addAttribute("message", message);

        return "browse";
    }

    @PostMapping("/search")
    public String getBrowseBySearch(
        @RequestParam("id") Long id,
        Model model
    ) {
        // search for furniture with specified ID
        FurnitureDTO furn = brosServ.getFurnitureById(id);

        List<FurnitureDTO> furniture = new ArrayList<>();

        if( furn != null) {
            furniture.add(furn);
        }

        String message = "Furniture with ID (" + id + ") does not exist";

        model.addAttribute("heading", "Search results for furniture ID (" + id + ")");
        model.addAttribute("furniture", furniture);
        model.addAttribute("message", message);

        return "browse";
    }
}
