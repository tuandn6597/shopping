package com.project.demo.services;

import com.project.demo.models.product;
import com.project.demo.models.promotion;
import java.util.List;

public interface PromotionServices {
    List<promotion> findAll();
    promotion findById(Integer id);
    promotion insert_promotion(promotion promotions);
    promotion update_promotion(promotion promotions);
    void deleteById(Integer id);
    List<promotion> findByName(String Name);
    List<product> findAllByIdPromotion(Integer id);
}
