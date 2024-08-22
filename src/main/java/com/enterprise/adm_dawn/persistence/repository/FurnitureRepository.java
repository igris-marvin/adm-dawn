package com.enterprise.adm_dawn.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.entity.Furniture;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    
    public Integer countByCategory(Category category);
}
