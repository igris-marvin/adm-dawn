package com.enterprise.adm_dawn.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.adm_dawn.persistence.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
