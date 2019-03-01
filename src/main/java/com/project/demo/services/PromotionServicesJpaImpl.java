package com.project.demo.services;

import com.project.demo.models.product;
import com.project.demo.models.promotion;
import com.project.demo.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServicesJpaImpl implements PromotionServices {
    @Autowired
    private PromotionRepository promotionRepository;
    @Override
    public List<promotion> findAll() {
        return this.promotionRepository.findAll();
    }

    @Override
    public promotion findById(Integer id) {
        return this.promotionRepository.findById(id).get();
    }

    @Override
    public promotion insert_promotion(promotion promotions) {
        return this.promotionRepository.save(promotions);
    }

    @Override
    public promotion update_promotion(promotion promotions) {
        return this.promotionRepository.save(promotions);
    }

    @Override
    public void deleteById(Integer id) {

        this.promotionRepository.deleteById(id);
    }

    @Override
    public List<promotion> findByName(String Name){
        return this.promotionRepository.findByName(Name);
    }

    @Override
    public List<product> findAllByIdPromotion(Integer id) {
        return this.promotionRepository.findAllByIdPromotion(id);
    }
}
