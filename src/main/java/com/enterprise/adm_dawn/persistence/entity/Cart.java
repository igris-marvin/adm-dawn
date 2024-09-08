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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Transient
    private Set<Furniture> furnitureList = new HashSet<>();

    private Integer numberOfItems;
    private Double totalPrice;

    public Cart(
        Integer numberOfItems, 
        Double totalPrice
    ) {
        this.numberOfItems = numberOfItems;
        this.totalPrice = totalPrice;
    }
}
