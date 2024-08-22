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

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
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

        return "create/c_furniture";
    }

    @PostMapping
    public String postCreateFurniture(
        @ModelAttribute("furniture") CategoryDTO dto,
        @RequestParam("displayImage") MultipartFile displayFile,
        @RequestParam("extraImages") List<MultipartFile> extraFiles,
        Model model
    ) {
        System.out.println(dto.toString());

        return "c_furniture_outcome";
    }

    @ModelAttribute("furniture")
    public CategoryDTO getCategoryDTO () {
        return new CategoryDTO();
    }
}
