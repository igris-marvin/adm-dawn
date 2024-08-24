package com.enterprise.adm_dawn.api.controller;

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
import com.enterprise.adm_dawn.api.service.CreateCategoryService;

@Controller
@RequestMapping("/category")
public class CreateCategoryController {

    @Autowired
    private CreateCategoryService ccServ;
    
    @GetMapping
    public String getCreateCategory(
        Model model
    ) {
        CategoryDTO dto = new CategoryDTO();

        model.addAttribute("dto", dto);

        return "create/create_category";
    }

    @PostMapping
    public String postCreateCategory(
        @ModelAttribute("category") CategoryDTO dto,
        @RequestParam("photo") MultipartFile file,
        Model model
    ) {

        String result = ccServ.createCategory(dto, file);

        model.addAttribute("result", result);

        return "outcome/create_category_outcome";
    }
}
