package com.crazycode.controller;

import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 添加产品
     *
     * @param product
     * @return
     * @throws Exception
     */
    @PostMapping("/addProduct")
    public String addProduct(Product product) throws Exception {
        productService.insertProduct(product);
        return "redirect:/findAllProducts";
    }

    /**
     * 查询所有产品
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllProducts")
    public ModelAndView findAllProducts() throws Exception {
        List<Product> products = productService.findAllProducts();
        ModelAndView modelAndView = new ModelAndView("pages/product-list1");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

}
