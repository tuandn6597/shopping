package com.project.demo.controllers;

import com.project.demo.models.customer;
import com.project.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customers",method = RequestMethod.GET)
    public String displayCustomer(Model model)
    {
        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("Customer",new customer());
        return "/admin/customers";
    }
    @RequestMapping(value="customer",method = RequestMethod.POST)
    public String saveCustomer(customer customer)
    {
       // customer.setCreateDate(Date.valueOf(date));
        customerService.insert_customer(customer);
        return "redirect:/customers";
    }
    @RequestMapping(value="customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id)
    {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
    @RequestMapping(value="customer/edit/{id}")
    public String updateCustomer(@PathVariable Integer id, Model model)
    {
        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("Customer", customerService.findById(id));
        return "/admin/customers";
    }

        @RequestMapping(value="customer/search",method = RequestMethod.POST)
    public String findCustomer(@RequestParam(value = "Name",required = true) String Name, Model model)
    {
        model.addAttribute("customers",customerService.findByName(Name));
        model.addAttribute("Customer",new customer());
        return "/admin/customers";
    }

}
