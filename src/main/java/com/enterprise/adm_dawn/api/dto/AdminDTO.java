package com.enterprise.adm_dawn.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Long adminId;
    private String username;
    private String password;
    private String email;
    private String dateAdded;
    
}
