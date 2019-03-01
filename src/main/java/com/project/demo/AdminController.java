package com.project.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


  @Controller
public class AdminController {
    @RequestMapping("/")
    public String index(){
        return "admin/index";
    }

    /*@RequestMapping("/tables-basic")
    public String tablesBasic(){
        return "admin/tables-basic";
      }
      @RequestMapping("/tables-data")
      public String tablesData()
      {
        return "admin/tables-data";
      }

      @RequestMapping("/forms-basic")
      public String formsBasic(){
        return "admin/forms-basic";
      }
      @RequestMapping("/forms-advanced")
      public String formsAdvanced()
      {
          return "admin/forms-advanced";
      }
      @RequestMapping("/page-login")
      public String pageLogin(){
        return "admin/page-login";
      }
      @RequestMapping("/page-register")
      public String pageRegister(){
        return "admin/page-register";
      }
      @RequestMapping("/pages-forget")
      public String pageForget(){
        return "admin/pages-forget";
      }
      @RequestMapping("/catalogForm")
      public String pageCatalogForm()
      {
          return "admin/catalogForm";
      }*/
     /* @RequestMapping("/catalogs")
      public String pageCatalog(){
            return "/admin/catalogs";
      }*/
     /* @RequestMapping("/products")
      public String pageProduct(){
        return "/admin/products";
      }*/
      /*@RequestMapping("/producers")

      public String pageProducer()
          {
              return "admin/producers";
          }
          @RequestMapping("/transactions")
      public String pageTransaction(){return "admin/transactions";}
      @RequestMapping("/details")
      public String pageDetail(){return "admin/details";}*/

}
