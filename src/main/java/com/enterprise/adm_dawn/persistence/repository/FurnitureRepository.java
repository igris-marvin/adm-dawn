package com.enterprise.adm_dawn.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.adm_dawn.persistence.entity.Category;
import com.enterprise.adm_dawn.persistence.entity.Furniture;
import com.enterprise.adm_dawn.persistence.entity.Image;

import java.util.List;


@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    
    public Integer countByCategory(Category category);

    public Iterable<Furniture> findByCategory(Category category);

    @Query("SELECT f.price FROM Furniture f WHERE f.furnitureId = :fid")
    public Double findPriceByFurnitureId(
        @Param("fid") Long furnitureId
    );
}
