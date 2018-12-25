package com.itcast.web;

import com.itcast.dao.ProductDao;
import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductContrlller {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")

    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        List<Product> products = productService.findAll();
        mav.addObject("products",products);
        System.out.println(products);
        mav.setViewName("product/product_list");
        return mav;
    }
}
