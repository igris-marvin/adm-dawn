package com.enterprise.adm_dawn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.api.service.ModifyService;

@Controller
@RequestMapping("/modify")
public class ModifyController {

    @Autowired
    private ModifyService modServ;

    @ModelAttribute("stats")
    public List<String> attachStatusNames() {
        return modServ.getStatusNames();
    }

    @ModelAttribute("discount")
    public List<String> attachDiscounts() {
        return modServ.getDiscountNames();
    }
    
    @ModelAttribute("categs")
    public List<String> attachCategories() {
        return modServ.getCategoryNames();
    }
    
    @GetMapping("/{id}")
    public String getModify(
        @PathVariable("id") Long id,
        Model model
    ) {
        FurnitureDTO furn = modServ.getFurnitureDTOByID(id);
        Double price = modServ.getFurniturePriceById(id);

        model.addAttribute("furn", furn);
        model.addAttribute("price", price);

        return "modify/modify_furniture";
    }

    @PostMapping
    public String postModify(
        @RequestParam("fid") Long id,
        @RequestParam("fname") String furnitureName,
        @RequestParam("fquan") Integer quantity,
        @RequestParam("fprice") String price,
        @RequestParam("fdesc") String description,
        @RequestParam("fstat") String status,
        @RequestParam("fcat") String category,
        @RequestParam("fdisc") String discount,
        @RequestParam("photo") MultipartFile file,
        Model model
    ) {
        FurnitureDTO dto = new FurnitureDTO(
            id,
            furnitureName,
            quantity,
            price,
            description,
            status,
            category,
            null,
            null,
            discount,
            null
        );

        Boolean result = modServ.modifyFurniture(dto, file);
        FurnitureDTO furn = modServ.getFurnitureDTOByID(id);
        Double pricer = modServ.getFurniturePriceById(id);

        model.addAttribute("result", Boolean.toString(result));
        model.addAttribute("furn", furn);
        model.addAttribute("price", pricer);

        return "modify/modify_furniture";
    }

    @PostMapping("/extra")
    public String postExtra(
        Model model
    ) {

        //attach result boolean as string
        //attach result message

        return "modify/modify_outcome";
    }
}
