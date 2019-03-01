package com.project.demo.controllers;
import com.project.demo.models.catalog;
import com.project.demo.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @RequestMapping(value="/catalogs",method=RequestMethod.GET)
    public String list(Model model)
    {
        model.addAttribute("isAdd",true);
        model.addAttribute("catalogs",catalogService.findAll());
        model.addAttribute("Catalog",new catalog());
        return "/admin/catalogs";
    }

    @PostMapping(value="/savecata")
    public String saveCatalog(Model model, @ModelAttribute catalog cata, RedirectAttributes redirectAttributes)
    {
        catalog ca=catalogService.insert_catalog(cata);
        if(ca!=null)
        {
            redirectAttributes.addFlashAttribute("successmessage","catalog is saved successfully");
            return "redirect:/catalogs";
        }
        else
        {
            model.addAttribute("erromessage","catalog is not save,please try again");
            model.addAttribute("Catalog",ca);
            return "catalogs";
        }

    }
    @PostMapping(value="/updatecata")
    public String updateCatalog(Model model, @ModelAttribute catalog cata, RedirectAttributes redirectAttributes)
    {
        catalog ca=catalogService.update_catalog(cata);
        if(ca!=null)
        {
            redirectAttributes.addFlashAttribute("successmessage","catalog is update successfully");
            return "redirect:/catalogs";
        }
        else
        {
            model.addAttribute("erromessage","catalog is not update,please try again");
            model.addAttribute("Catalog",ca);
            return "/admin/catalogs";
        }

    }
    @RequestMapping("catalog/{id_catalog}")
    public String showCatalog(@PathVariable Integer  id_catalog, Model model)
    {
     model.addAttribute("catalog",catalogService.findById(id_catalog));
        return "/admin/catalogshow";
    }
   /* @RequestMapping (value = "/catalogs")
    public String newCatalog(Model model)
    {

        return "catalogs";

    }*/
    @RequestMapping("catalog/delete/{id_catalog}")
    public String delete(@PathVariable Integer  id_catalog, RedirectAttributes redirectAttributes) {
        catalogService.deleteById(id_catalog);
        redirectAttributes.addFlashAttribute("successmessage","catalog is delete successfully");
        return "redirect:/catalogs";
    }
    @RequestMapping("/catalog/edit/{id_catalog}")
    public String edit(@PathVariable Integer  id_catalog, Model model) {
        model.addAttribute("Catalog", catalogService.findById(id_catalog));
        model.addAttribute("catalogs",catalogService.findAll());
        model.addAttribute("isAdd",false);
        return "/admin/catalogs";
    }
}
