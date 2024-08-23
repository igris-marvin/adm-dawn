package com.enterprise.adm_dawn.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureDTO {
    private Long furnitureId;
    private String furnitureName;
    private Integer quantity;
    private String price;
    private String description;
    private String status;
    private String category;
    private String displayImage;
    private List<String> extraImages;
    private String discount;
    private String dateAdded;
}
