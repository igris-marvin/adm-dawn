package com.enterprise.adm_dawn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.api.service.CreateFurnitureService;

@Controller
@RequestMapping("/furniture")
public class CreateFurnitureController {

    @Autowired
    private CreateFurnitureService cfServ;

    @GetMapping
    public String getCreateFurniture(
        Model model
    ) {
        List<String> categs = cfServ.getCategories();
        List<String> stats = cfServ.getStatuses();
        List<String> discounts = cfServ.getDiscounts();

        model.addAttribute("furniture", new FurnitureDTO());
        model.addAttribute("categs", categs);
        model.addAttribute("stats", stats);
        model.addAttribute("discounts", discounts);

        return "create/create_furniture";
    }

    @PostMapping
    public String postCreateFurniture(
        @ModelAttribute("furniture") FurnitureDTO dto,
        @RequestParam("photo") MultipartFile file,
        Model model
    ) {
        boolean result = cfServ.createFurniture(dto, file);

        model.addAttribute("result", Boolean.toString(result));

        return "outcome/create_furniture_outcome";
    }
}