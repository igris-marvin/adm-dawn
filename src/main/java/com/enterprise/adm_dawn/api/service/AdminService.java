package com.enterprise.adm_dawn.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.api.dto.AdminDTO;
import com.enterprise.adm_dawn.persistence.entity.Admin;
import com.enterprise.adm_dawn.persistence.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private ConverterService convServ;
    
    @Autowired
    private AdminRepository admRepo;

    public AdminDTO getAdminProfile(
        Long id
    ) {
        Admin admin = admRepo.findById(id).get();

        AdminDTO dto = convServ.convertAdmin(admin);

        return dto;
    }
}
