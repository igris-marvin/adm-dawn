package com.enterprise.adm_dawn.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enterprise.adm_dawn.persistence.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    public List<String> findAllCategoryNameList();
}
