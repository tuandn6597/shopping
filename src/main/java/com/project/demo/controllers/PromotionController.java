package com.project.demo.controllers;

import com.project.demo.models.product;
import com.project.demo.models.promotion;
import com.project.demo.services.ProductService;
import com.project.demo.services.PromotionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class PromotionController {
    @Autowired
    private PromotionServices promotionServices;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/promotions", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("promotions", promotionServices.findAll());
        model.addAttribute("Promotion", new promotion());
        return "/admin/promotions";
    }

    @RequestMapping(value = "promotion", method = RequestMethod.POST)
    public String savePromotion(promotion promotion,String datestart,String dateend) {
        promotion.setDateStart(Date.valueOf(datestart));
        promotion.setDateEnd(Date.valueOf(dateend));
        promotionServices.insert_promotion(promotion);
        return "redirect:/promotions";
    }

    @RequestMapping(value="promotion/delete/{id}")
    public String deletePromotion(@PathVariable Integer id)
    {
    List<product> listProducts= promotionServices.findAllByIdPromotion(id);
       for (product p : listProducts )
        {
            p.setPromotion(null);
        }
        promotionServices.deleteById(id);
        return "redirect:/promotions";
    }
    @RequestMapping(value="promotion/edit/{id}")
    public String updatePromotion(@PathVariable Integer id, Model model)
    {
        model.addAttribute("promotions",promotionServices.findAll());
        model.addAttribute("Promotion", promotionServices.findById(id));
        return "/admin/promotions";
    }

    @RequestMapping(value = "/promotion/search",method = RequestMethod.POST)
    public String search(@RequestParam(value = "Name") String Name, Model model)
    {
        model.addAttribute("promotions",promotionServices.findByName(Name));
        model.addAttribute("Promotion", new promotion());
        return "/admin/promotions";
    }
}

