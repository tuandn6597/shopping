package com.project.demo.controllers;

import com.project.demo.models.producer;
import com.project.demo.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProducerController {
    @Autowired
    private ProducerService producerService;
    @RequestMapping(value="producers",method = RequestMethod.GET)
    public String displayProducer(Model model)
    {
        model.addAttribute("produces",producerService.findAll());
        model.addAttribute("Producer",new producer());
        return "/admin/producers";
    }
    @RequestMapping(value="producer",method = RequestMethod.POST)
    public String saveProducer(producer pro)
    {
        producerService.insert_producer(pro);
        return "redirect:/producers";
    }
    @RequestMapping(value="producer/delete/{id}")
    public String deleteProducer(@PathVariable Integer id)
    {
        producerService.deleteById(id);
        return "redirect:/producers";
    }
    @RequestMapping(value="producer/edit/{id}")
    public String updateProducer(@PathVariable Integer id,Model model)
    {
        model.addAttribute("produces",producerService.findAll());
        model.addAttribute("Producer", producerService.findById(id));

        return "/admin/producers";
    }
}
