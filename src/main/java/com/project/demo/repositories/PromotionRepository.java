package com.project.demo.repositories;

import com.project.demo.models.product;
import com.project.demo.models.promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<promotion,Integer> {
    @Query("Select p from promotion p where p.NameFree like %:Name%")
    List<promotion> findByName(String Name);
    @Query("Select p from product p where p.promotion.id= ?1")
    List<product> findAllByIdPromotion(Integer id);
}
