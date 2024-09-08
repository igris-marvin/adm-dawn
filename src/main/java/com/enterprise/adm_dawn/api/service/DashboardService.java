package com.enterprise.adm_dawn.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;
import com.enterprise.adm_dawn.persistence.repository.CustomerRepository;

@Service
public class DashboardService {

    @Autowired
    private ConverterService converter;
    
    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private CustomerRepository custRepo;

    public List<CategoryDTO> getCategories(

    ) {
        List<CategoryDTO> dlist = new ArrayList<>();

        List<Category> clist = catRepo.findAll();

        for (Category c : clist) {
            
            CategoryDTO dto = converter.convertCategory(c);

            dlist.add(dto);
        }

        return dlist;
    }

    public Integer getCustomerSize() {
        return (int) custRepo.count();
    }
}
