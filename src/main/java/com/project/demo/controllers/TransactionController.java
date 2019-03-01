package com.project.demo.controllers;

import com.project.demo.models.transaction;
import com.project.demo.services.CustomerService;
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
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CustomerService customerService;
    @GetMapping(value="transactions")
    public String display(Model model)
    {
        model.addAttribute("transactions",transactionService.findAll());
        model.addAttribute("transaction",new transaction());
        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("isAdd",true);
        return "/admin/transactions";
    }
    @PostMapping(value="/savetran")
    public String saveTransaction(Model model, @ModelAttribute transaction tran, RedirectAttributes redirectAttributes)
    {
        transaction trans=transactionService.insert_transaction(tran);
        if(trans!=null)
        {
            redirectAttributes.addFlashAttribute("successmessage","transaction is saved successfully");
            return "redirect:/transactions";
        }
        else
        {
            model.addAttribute("erromessage","transaction is not save,please try again");
            model.addAttribute("transaction",tran);
            return "/admin/transactions";
        }
    }
   @GetMapping(value="/transaction/edit/{id}")
   public String editTransaction(@PathVariable Integer id,Model model)
   {
       model.addAttribute("transactions",transactionService.findAll());
       model.addAttribute("transaction",transactionService.findById(id));
       model.addAttribute("customers",customerService.findAll());
       model.addAttribute("isAdd",false);
       return "/admin/transactions";
   }
   @PostMapping(value = "/updatetran")
    public String updateTransaction(Model model, @ModelAttribute transaction tran, RedirectAttributes redirectAttributes){
       transaction trans=transactionService.insert_transaction(tran);
       if(trans!=null)
       {
           redirectAttributes.addFlashAttribute("successmessage","transaction is update successfully");
           return "redirect:/transactions";
       }
       else
       {
           model.addAttribute("erromessage","transaction is not update,please try again");
           model.addAttribute("transaction",tran);
           return "transactions";
       }
   }
   @GetMapping(value="transaction/delete/{id}")

       public String deleteTransaction(@PathVariable Integer id,RedirectAttributes redirectAttributes)
       {
           transactionService.deleteById(id);
           redirectAttributes.addFlashAttribute("successmessage","transaction is delete successfully");
           return "redirect:/transactions";
       }

}
