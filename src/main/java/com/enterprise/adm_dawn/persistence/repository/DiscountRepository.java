package com.enterprise.adm_dawn.persistence.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enterprise.adm_dawn.persistence.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    
    @Query("SELECT d.discountTitle FROM Discount d")
    public Iterable<String> findAllDiscountTitle();
}
