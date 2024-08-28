package com.enterprise.adm_dawn.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.persistence.entity.Discount;
import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.entity.Furniture.FurnitureStatus;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;
import com.enterprise.adm_dawn.persistence.repository.DiscountRepository;
import com.enterprise.adm_dawn.persistence.repository.FurnitureRepository;

@Service
public class ModifyService {
    
    @Autowired
    private ConverterService convServ;

    @Autowired
    private FurnitureRepository furnRepo;

    @Autowired
    private DiscountRepository discRepo;

    @Autowired
    private CategoryRepository catRepo;

    public FurnitureDTO getFurnitureDTOByID(
        Long id
    ) {
        Optional<Furniture> opt = furnRepo.findById(id);

        FurnitureDTO furn = opt.isPresent() ? convServ.convertFurniture(opt.get()) : new FurnitureDTO();

        return furn;
    }

    public List<String> getStatusNames() {
        List<String> slist = new ArrayList<>();

        FurnitureStatus[] stats = FurnitureStatus.values();

        for (FurnitureStatus x : stats) {
            
            String name = x.getFurnStatus();

            slist.add(name);
        }

        return slist;
    }

    public List<String> getDiscountNames() {
        List<String> dlist = (List<String>) discRepo.findAllDiscountTitle();

        return dlist;
    }

    public List<String> getCategoryNames() {
        List<String> clist = (List<String>) catRepo.findAllCategoryNames();

        return clist;
    }

    public Double getFurniturePriceById(
        Long id
    ) {
        Double price = 0.0;

        try {
            price = furnRepo.findPriceByFurnitureId(id);

        } catch(Exception e) {
            
            System.err.println(e.getMessage());
        }

        return price;
    }

    public boolean modifyFurniture(
        FurnitureDTO dto, 
        MultipartFile file
    ) {
        try {
            
            Furniture furniture = convServ.convertModifiedFurnitureDTO(dto, file);

            furnRepo.save(furniture);

            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
