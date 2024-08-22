package com.enterprise.adm_dawn.api.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.repository.FurnitureRepository;

@Service
public class ConverterService {

    @Autowired
    private FurnitureRepository furnRepo;

    public CategoryDTO convertCategory(Category c) {
        
        Long categoryId = c.getCategoryId();
        String categoryName = c.getCategoryName();
        String description = c.getDescription();
        String displayImage = "data:image/jpg;base64," + Base64
                                        .getEncoder()
                                        .encodeToString(
                                            c.getDisplayImage()
                                        );
        String dateAdded = c.getDateAdded().toString();
        int noOfItems = furnRepo.countByCategory(c);

        return new CategoryDTO(categoryId, categoryName, description, displayImage, dateAdded, noOfItems);
    }
    
}
