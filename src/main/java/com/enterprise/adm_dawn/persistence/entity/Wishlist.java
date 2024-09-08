package com.enterprise.adm_dawn.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistId;
    
    @Transient
    private Set<Furniture> furnitureList = new HashSet<>();
    
    private Integer numberOfItems;
    private Double totalPrice;

    public Wishlist(
        Integer numberOfItems, 
        Double totalPrice
    ) {
        this.numberOfItems = numberOfItems;
        this.totalPrice = totalPrice;
    }
}
