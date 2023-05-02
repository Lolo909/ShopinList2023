package com.example.shopinglist2023.web;

import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;
import com.example.shopinglist2023.service.ProductService;
import com.example.shopinglist2023.utl.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        if (currentUser.getId() == null) {
            modelAndView.setViewName("index");
        } else {

            BigDecimal sum = productService.findAllItemsPrice();
            if(sum==null){
                sum= BigDecimal.valueOf(0);
            }

            modelAndView.addObject("allItemsPrice", sum);
            modelAndView.addObject("drinks",
                    productService.findAllProdByCatgName(CategoryNameEnum.Drink));
            modelAndView.addObject("food",
                    productService.findAllProdByCatgName(CategoryNameEnum.Food));
            modelAndView.addObject("household",
                    productService.findAllProdByCatgName(CategoryNameEnum.Household));
            modelAndView.addObject("other",
                    productService.findAllProdByCatgName(CategoryNameEnum.Other));
            modelAndView.setViewName("home");

        }

        return modelAndView;
    }
}
