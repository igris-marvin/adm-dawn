package com.enterprise.adm_dawn.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.api.dto.AdminDTO;
import com.enterprise.adm_dawn.exception.PasswordUnmatchedException;
import com.enterprise.adm_dawn.persistence.entity.Admin;
import com.enterprise.adm_dawn.persistence.repository.AdminRepository;

@Service
public class RegisterAdminService {

    @Autowired
    private ConverterService convServ;
    
    @Autowired
    private AdminRepository admRepo;

    public String registerAdmin(
        AdminDTO dto, 
        String re_password
    ) {
        try {

            verifyPasswords(dto.getPassword(), re_password);
            verifyEmailAndUsername(dto.getEmail(), dto.getUsername());

            Admin admin = convServ.convertAdminDTO(dto);

            admRepo.save(admin);

            return "true";
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return "Error!, Admin with either email" + dto.getEmail() + " or username " + dto.getUsername() + " already exist!";
        } catch (PasswordUnmatchedException e) {

            System.err.println(e.getMessage());

            return "Error!, Passwords do not match!";
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

        return "false";
    }

    private void verifyEmailAndUsername(
        String email, 
        String username
    ) throws SQLException {
        List<Admin> list = admRepo.findAll();

        for (Admin x : list) {
            
            if(x.getEmail().equalsIgnoreCase(email) && x.getUsername().equalsIgnoreCase(username)) {
                throw new SQLException("Duplicate email or username");
            }
        }
    }

    private void verifyPasswords(
        String password, 
        String re_password
    ) throws PasswordUnmatchedException {
        
        if( !(password.equals(re_password)) ) {
            throw new PasswordUnmatchedException("Passwords do not match exception!");
        }
    }
}
