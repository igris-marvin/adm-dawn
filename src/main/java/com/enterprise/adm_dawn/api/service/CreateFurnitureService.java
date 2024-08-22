package com.enterprise.adm_dawn.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.entity.Furniture.FurnitureStatus;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;
import com.enterprise.adm_dawn.persistence.repository.DiscountRepository;

@Service
public class CreateFurnitureService {

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private DiscountRepository discRepo;

    public List<String> getCategories() {
        List<String> list = (List<String>) catRepo.findAllCategoryNames();

        return list;
    }

    public List<String> getStatuses() {
        FurnitureStatus[] arr = Furniture.FurnitureStatus.values();

        List<String> list = new ArrayList<>();

        for (FurnitureStatus x : arr) {
            String stat = x.getFurnStatus();

            list.add(stat);
        }

        return list;
    }

    public List<String> getDiscounts() {
        List<String> list = (List<String>) discRepo.findAllDiscountTitle();

        return list;
    }
    
}
