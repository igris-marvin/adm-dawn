package com.enterprise.adm_dawn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.adm_dawn.api.service.RemoveService;

@Controller
@RequestMapping("/remove")
public class RemoveController {

    @Autowired
    private RemoveService remServ;
    
    @GetMapping("/furniture/{id}")
    public String getRemoveFurniture(
        @PathVariable("id") Long id,
        Model model
    ) {
        Boolean result = remServ.removeFurniture(id);

        String message = "no message";
        
        if(result) {
            message = "Furniture with id (" + id + ") removed successfully!";

        } else {
            
            message = "Removal of furniture with id (" + id + ") was unsuccessful! please try again";
        }
        
        model.addAttribute("message", message);
        model.addAttribute("result", Boolean.toString(result));

        return "outcome/remove_outcome";
    }
}
