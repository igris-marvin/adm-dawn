package com.enterprise.adm_dawn.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.adm_dawn.persistence.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    
}
