package com.enterprise.adm_dawn.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;
import com.enterprise.adm_dawn.persistence.repository.FurnitureRepository;

@Service
public class BrowseService {
    
    @Autowired
    private ConverterService convServ;

    @Autowired
    private FurnitureRepository furnRepo;

    @Autowired
    private CategoryRepository catRepo;

    public List<FurnitureDTO> getFurniture() {

        List<Furniture> list = furnRepo.findAll();
        List<FurnitureDTO> dlist = new ArrayList<>();

        for (Furniture x : list) {
            
            FurnitureDTO dto = convServ.convertFurniture(x);
            
            dlist.add(dto);

        }

        return dlist;
    }

    public List<FurnitureDTO> getFurnitureByCategory(
        Long categoryId
    ) {
        List<FurnitureDTO> dlist = new ArrayList<>();

        try {
            Category category = catRepo.findById(categoryId).get();

            List<Furniture> li = (List<Furniture>) furnRepo.findByCategory(category);

            if(!li.isEmpty()) {

                for (Furniture x : li) {

                    FurnitureDTO dto = convServ.convertFurniture(x);

                    dlist.add(dto);
                }

            } else {
                return dlist;
            }

            return dlist;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return dlist;
    }

    public FurnitureDTO getFurnitureById(
        Long furnitureId
    ) {
        Optional<Furniture> furn = furnRepo.findById(furnitureId);

        FurnitureDTO dto = furn.isPresent() ? convServ.convertFurniture(furn.get()) : null;

        return dto;
    }

    public CategoryDTO getCategory(Long id) {

        Optional<Category> cat = catRepo.findById(id);

        CategoryDTO dto = cat.isPresent() ? convServ.convertCategory(cat.get()) : null;

        return dto;
    }
}
