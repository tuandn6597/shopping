package com.project.demo.controllers;

import com.project.demo.models.detail;
import com.project.demo.services.DetailService;
import com.project.demo.services.ProductService;
import com.project.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DetailController {
    @Autowired
    private DetailService detailService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ProductService productService;
    @GetMapping(value="details")
    public String displayDetail(Model model){
        model.addAttribute("details",detailService.findAll());
        model.addAttribute("detail",new detail());
        model.addAttribute("transactionss",transactionService.findAll());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("isAdd",true);
        return "/admin/details";
    }
    @PostMapping(value="/savedetail")
    public String saveTransaction(Model model, @ModelAttribute detail details, RedirectAttributes redirectAttributes)
    {
        detail d=detailService.insert_details(details);
        if(d!=null)
        {
            redirectAttributes.addFlashAttribute("successmessage","details is saved successfully");
            return "redirect:/details";
        }
        else
        {
            model.addAttribute("erromessage","details is not save,please try again");
            model.addAttribute("detail",d);
            return "/admin/details";
        }
    }
    @GetMapping(value="/detail/edit/{id}")
    public String editTransaction(@PathVariable Integer id, Model model)
    {
        model.addAttribute("details",detailService.findAll());
        model.addAttribute("detail",detailService.findById(id));
        model.addAttribute("transactionss",transactionService.findAll());
        model.addAttribute("products",productService.findAll());

        model.addAttribute("isAdd",false);
        return "/admin/details";
    }
    @PostMapping(value = "/updatedetail")
    public String updateDetail(Model model, @ModelAttribute detail details, RedirectAttributes redirectAttributes){
        detail d=detailService.update_details(details);
        if(d!=null)
        {
            redirectAttributes.addFlashAttribute("successmessage","details is update successfully");
            return "redirect:/details";
        }
        else
        {
            model.addAttribute("erromessage","details is not update,please try again");
            model.addAttribute("detail",d);
            return "/admin/details";
        }
    }
    @GetMapping(value="detail/delete/{id}")

    public String deleteDetail(@PathVariable Integer id,RedirectAttributes redirectAttributes)
    {

        detailService.deleteById(id);
        redirectAttributes.addFlashAttribute("successmessage","details is delete successfully");
        return "redirect:/details";
    }
}
