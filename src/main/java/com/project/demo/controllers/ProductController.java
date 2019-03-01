package com.project.demo.controllers;

import com.project.demo.models.Pager;
import com.project.demo.models.detail;
import com.project.demo.models.product;
import com.project.demo.models.product_file;

import com.project.demo.services.CatalogService;
import com.project.demo.services.ProducerService;
import com.project.demo.services.ProductService;
import com.project.demo.services.PromotionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class ProductController {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};

    @Autowired
    private ProductService productService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private PromotionServices promotionServices;
    @GetMapping(value="/products")
    public ModelAndView products(Model model,@RequestParam("pageSize") Optional<Integer> pageSize,
                           @RequestParam("page") Optional<Integer> page)
    {
        ModelAndView modelAndView = new ModelAndView("/admin/products");
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
      //  List<product> products= productService.findAll();
        Page<product> products = productService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
       Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
        /*model.addAttribute("products",products);
        model.addAttribute("product",new product());
        model.addAttribute("productFiles",new ArrayList<product_file>());
        model.addAttribute("catalog",catalogService.findAll());

        model.addAttribute("producer",producerService.findAll());
        model.addAttribute("isAdd",true);*/
        modelAndView.addObject("promotions",promotionServices.findAll());
        modelAndView.addObject("products",products);
        modelAndView.addObject("product",new product());
        modelAndView.addObject("productFiles",new ArrayList<product_file>());
        modelAndView.addObject("catalog",catalogService.findAll());
        modelAndView.addObject("isSearch",false);
        modelAndView.addObject("producer",producerService.findAll());
        modelAndView.addObject("isAdd",true);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;
    }
    @PostMapping(value="/save")
    public String saveProduct(@ModelAttribute product pro, RedirectAttributes redirectAttributes,Model model)
    {
        product p=  productService.insert_product(pro);
        if(p!=null)
        {
            redirectAttributes.addFlashAttribute("successmessage","product is saved successfully");
            return "redirect:/products";
        }else{
            model.addAttribute("erromessage","product is not save,please try again");
            model.addAttribute("product",pro);
            return "products";

        }


    }
    @GetMapping(value="/product/edit/{id}")
    public ModelAndView editProduct(@PathVariable Integer id, Model model,@RequestParam("pageSize") Optional<Integer> pageSize,
                              @RequestParam("page") Optional<Integer> page)
    {
        product pro=productService.findById(id);
        List<product_file> product_files=productService.findFilesByProductId(id);
       // List<product> products= productService.findAll();
       // model.addAttribute("products",products);
        ModelAndView modelAndView = new ModelAndView("/admin/products");

        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        //  List<product> products= productService.findAll();
        Page<product> products = productService.findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);



       /* model.addAttribute("product",pro);
        model.addAttribute("productFiles",product_files);
        model.addAttribute("catalog",catalogService.findAll());
        model.addAttribute("producer",producerService.findAll());
        model.addAttribute("isAdd",false);*/

        modelAndView.addObject("promotions",promotionServices.findAll());
        modelAndView.addObject("product",pro);
        modelAndView.addObject("products",products);
        modelAndView.addObject("productFiles",product_files);
        modelAndView.addObject("catalog",catalogService.findAll());
        modelAndView.addObject("producer",producerService.findAll());
        modelAndView.addObject("isAdd",false);
        modelAndView.addObject("isSearch",false);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
    @PostMapping(value="/update")
    public String updateProduct(@ModelAttribute product pro, RedirectAttributes redirectAttributes,Model model) {
        product p = productService.update_product(pro);
        if (p != null) {
            redirectAttributes.addFlashAttribute("successmessage", "product is update successfully");
            return "redirect:/products";
        } else {
            model.addAttribute("erromessage", "product is not update,please try again");
            model.addAttribute("product", pro);
            return "/admin/products";

        }
    }
    @GetMapping(value="/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id)
    {
        List<detail> listDetail= productService.findAllDetailByIdProduct(id);
        for (detail p : listDetail )
        {
            p.setProduct(null);
        }
        productService.deleteById(id);
        return "redirect:/products";

    }
   /* @GetMapping(value="product/images/{id}")
    public String getImagesById(@PathVariable Integer id)
    {


    }*/
   @RequestMapping(value = "/product/search",method = RequestMethod.GET)
   public String search(@RequestParam(value = "Name") String Name, Model model)
   {
       model.addAttribute("products",productService.findProductByName(Name));
       model.addAttribute("product", new product());

        model.addAttribute("isSearch",true);
       model.addAttribute("catalog",catalogService.findAll());
       model.addAttribute("producer",producerService.findAll());
       return "/admin/products";
   }
   @GetMapping(value="/product/view/{id}")
   public String viewProduct(@PathVariable Integer id, Model model
   )
   {
      model.addAttribute("products",productService.findById(id)) ;
       List<product_file> product_files=productService.findFilesByProductId(id);
       model.addAttribute("productFiles",product_files);
       return "admin/viewproducts";
   }


}
