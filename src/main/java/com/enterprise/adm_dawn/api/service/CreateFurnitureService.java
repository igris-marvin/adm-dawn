package com.enterprise.adm_dawn.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.persistence.entity.Discount;
import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.entity.Furniture.FurnitureStatus;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;

@Service
public class CreateFurnitureService {

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private Discount discRepo;

    public List<String> getCategories() {
        List<String> list = catRepo.findAllCategoryNameList();

        return list;
    }

    public List<String> getStatuses() {
        FurnitureStatus[] arr = Furniture.FurnitureStatus.values();

        List<String> list = new ArrayList<>();

        for (FurnitureStatus x : arr) {
            
        }
    }

    public List<String> getDiscounts() {
        List<String>
    }
    
}
