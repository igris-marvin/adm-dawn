package com.enterprise.adm_dawn.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.entity.Furniture.FurnitureStatus;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;
import com.enterprise.adm_dawn.persistence.repository.DiscountRepository;
import com.enterprise.adm_dawn.persistence.repository.FurnitureRepository;

@Service
public class CreateFurnitureService {

    @Autowired
    private ConverterService convServ;

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private DiscountRepository discRepo;

    @Autowired
    private FurnitureRepository furnRepo;

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

    public boolean createFurniture(
        FurnitureDTO dto, 
        MultipartFile file
    ) {

        try {
            Furniture furniture = convServ.convertFurnitureDTO(dto, file);

            furnRepo.save(furniture);

            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
    
}
