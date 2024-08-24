package com.enterprise.adm_dawn.api.service;

import java.util.Base64;
import java.util.List;
import java.util.Date;
import java.io.IOException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enterprise.adm_dawn.api.dto.AdminDTO;
import com.enterprise.adm_dawn.api.dto.CategoryDTO;
import com.enterprise.adm_dawn.api.dto.CustomerDTO;
import com.enterprise.adm_dawn.api.dto.FurnitureDTO;
import com.enterprise.adm_dawn.persistence.entity.Admin;
import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.entity.Customer;
import com.enterprise.adm_dawn.persistence.entity.Discount;
import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.entity.Image;
import com.enterprise.adm_dawn.persistence.entity.Furniture.FurnitureStatus;
import com.enterprise.adm_dawn.persistence.repository.CategoryRepository;
import com.enterprise.adm_dawn.persistence.repository.DiscountRepository;
import com.enterprise.adm_dawn.persistence.repository.FurnitureRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Service
public class ConverterService {

    @Autowired
    private FurnitureRepository furnRepo;
    
    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private DiscountRepository discRepo;

    public CategoryDTO convertCategory(Category c) {
        
        Long categoryId = c.getCategoryId();
        String categoryName = c.getCategoryName();
        String description = c.getDescription();
        String displayImage = "data:image/jpg;base64," + Base64
                                        .getEncoder()
                                        .encodeToString(
                                            c.getDisplayImage()
                                        );
        String dateAdded = c.getDateAdded().toString();
        int noOfItems = furnRepo.countByCategory(c);

        return new CategoryDTO(categoryId, categoryName, description, displayImage, dateAdded, noOfItems);
    }

    public Furniture convertFurnitureDTO(
        FurnitureDTO dto, 
        MultipartFile file
    ) {
        String furnitureName = dto.getFurnitureName();
        Integer quantity = dto.getQuantity();
        Double price = Double.parseDouble(dto.getPrice());
        String description = dto.getDescription();
        FurnitureStatus status = resolveStatus(dto.getStatus());
        Category category = resolveCategory(dto.getCategory());
        Image displayImage = resolveImage(file);
        List<Image> extraImages = null;
        Discount discount = resolveDiscount(dto.getDiscount());
        Date dateAdded = Date.from(Instant.now());

        return new Furniture(
            furnitureName, 
            quantity, 
            price, 
            description, 
            status, 
            category, 
            displayImage, 
            extraImages, 
            discount, 
            dateAdded
        );
    }

    private Discount resolveDiscount(
        String discount
    ) {

        if(!discount.equalsIgnoreCase("null")) {

            List<Discount> list = discRepo.findAll();

            for (Discount x : list) {
                
                if(x.getDiscountTitle().equalsIgnoreCase(discount)) {
                    return x;
                }
            }
        }

        return null;
    }

    private Image resolveImage(
        MultipartFile file
    ) {
        String imageTitle = file.getOriginalFilename();
        Double imageSize = file.getSize() / 1000000.0;
        
        byte[] imageSource = null;

        try {
            imageSource = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date dateAdded = Date.from(Instant.now());

        return new Image(imageTitle, imageSize, imageSource, dateAdded);
    }

    private Category resolveCategory(
        String category
    ) {
        List<Category> list = catRepo.findAll();

        for (Category x : list) {
            
            if(x.getCategoryName().equalsIgnoreCase(category)) {
                return x;
            }
        }

        System.err.println("Chosen category cannot be resolved");
        return list.get(0);
    }

    private FurnitureStatus resolveStatus(
        String status
    ) {
        FurnitureStatus[] arr = FurnitureStatus.values();

        for (FurnitureStatus x : arr) {
            
            if(x.getFurnStatus().equalsIgnoreCase(status)) {
                return x;
            }
        }

        System.err.println("Chosen status cannot be resolved");
        return FurnitureStatus.UNAVAILABLE;
    }

    public Category convertCategoryDTO(
        CategoryDTO dto, 
        MultipartFile file
    ) {
        
        String categoryName = dto.getCategoryName();
        String description = dto.getDescription();
        
        byte[] displayImage = null;

        try {
            displayImage = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Date dateAdded = Date.from(Instant.now());

        return new Category(
            categoryName, 
            description, 
            displayImage, 
            dateAdded
        );
    }

    public Admin convertAdminDTO(AdminDTO dto) {

        String username = dto.getUsername();

        //encrypt password
        String password = dto.getPassword();
        String email = dto.getEmail();
        Date dateAdded = Date.from(Instant.now());

        return new Admin(
            username, 
            password, 
            email, 
            dateAdded
        );
    }

    public CustomerDTO convertCustomer(
        Customer x
    ) {

        Long customerId = x.getCustomerId();
        String username = x.getUsername();
        String password = null;
        String email = x.getEmail();
        String contact = x.getContact();
        String name = x.getName();
        String surname = x.getSurname();
        char gender = x.getGender().custGender;
        String dateOfBirth = x.getDateOfBirth().toString();
        String photo = "data:image/jpg;base64," + Base64
                                .getEncoder()
                                .encodeToString(
                                    x
                                    .getPhoto()
                                );
        String dateJoined = x.getDateJoined().toString();

        return new CustomerDTO(
            customerId, 
            username, 
            password, 
            email, 
            contact, 
            name, 
            surname, 
            gender, 
            dateOfBirth, 
            photo, 
            dateJoined
        );
    }
    
}
