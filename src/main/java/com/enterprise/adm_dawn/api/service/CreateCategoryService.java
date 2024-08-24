package com.enterprise.adm_dawn.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.exception.DuplicateCategoryException;
import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;

@Service
public class CreateCategoryService {

    @Autowired
    private ConverterService convServ;
    
    @Autowired
    private CategoryRepository catRepo;

    public String createCategory(
        CategoryDTO dto, 
        MultipartFile file
    ) {

        try {
            
            checkCategoryDuplication(dto.getCategoryName());

            Category category = convServ.convertCategoryDTO(dto, file);

            catRepo.save(category);

            return "true";

        } catch (DuplicateCategoryException e) {
            System.err.println(e.getMessage());

            return "Error, Duplicate Category entry";

        } catch (Exception e) {
            System.err.println(e.getMessage());
            
        }

        return "false";
    }

    private void checkCategoryDuplication(
        String categoryName
    ) throws DuplicateCategoryException {

        List<Category> list = catRepo.findAll();

        for (Category x : list) {
            
            if(x.getCategoryName().equalsIgnoreCase(categoryName)) {
                throw new DuplicateCategoryException("Error!, duplicate category entry");
            }
        }
    }

    
}
