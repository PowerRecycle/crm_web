package com.crazycode.controller;

import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequiresRoles(value = {"admin", "productManager", "Java开发初级程序员"}, logical = Logical.OR)
    @RequiresPermissions("product:add")
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
    @RequiresRoles(value = {"admin", "productManager", "Java开发初级程序员"}, logical = Logical.OR)
    public ModelAndView findAllProducts() throws Exception {
        List<Product> products = productService.findAllProducts();
        ModelAndView modelAndView = new ModelAndView("pages/product-list1");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @PostMapping("/deleteProducts")
    @RequiresPermissions("product:delete")
    @RequiresRoles(value = {"admin", "productManager", "Java开发初级程序员"}, logical = Logical.OR)
    public String deleteProducts(@RequestParam(value = "ids") List<String> ids) throws Exception {
        System.out.println("11111111111111" + ids);
        for (String id : ids) {
            productService.deleteProduct(id);
        }
        return "redirect:/findAllProducts";
    }

    @PostMapping("/openProducts")
    @RequiresRoles(value = {"admin", "productManager", "Java开发初级程序员"}, logical = Logical.OR)
    public String openProducts(@RequestParam(value = "ids") List<String> ids) throws Exception {
        System.out.println("openProducts*************" + ids);
        for (String id : ids) {
            productService.openProduct(productService.findProductById(id));
        }
        return "redirect:/findAllProducts";
    }

    @PostMapping("/closeProducts")
    @RequiresRoles(value = {"admin", "productManager", "Java开发初级程序员"}, logical = Logical.OR)
    public String closeProducts(@RequestParam(value = "ids") List<String> ids) throws Exception {
        System.out.println("closeProducts***********" + ids);
        for (String id : ids) {
            productService.closeProduct(productService.findProductById(id));
        }
        return "redirect:/findAllProducts";
    }
}
