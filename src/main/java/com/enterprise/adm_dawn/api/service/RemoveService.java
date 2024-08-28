package com.enterprise.adm_dawn.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.persistence.repository.FurnitureRepository;

@Service
public class RemoveService {
    
    @Autowired
    private FurnitureRepository furnRepo;

    public Boolean removeFurniture(
        Long id
    ) {

        try {
            furnRepo.deleteById(id);

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());

            return false;
        }
    }
}
