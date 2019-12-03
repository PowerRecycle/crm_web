package com.crazycode.controller;

import com.crazycode.pojo.Orders;
import com.crazycode.service.OrdersService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/findOrderById/{id}")
    @RequiresRoles(value = {"admin", "orderManager", "Java开发初级程序员"}, logical = Logical.OR)
    public ModelAndView findOrderById(@PathVariable String id) throws Exception {
        Orders orders = ordersService.findOrderById(id);
        ModelAndView modelAndView = new ModelAndView("pages/orders-show");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/findAllOrders")
    @RequiresRoles(value = {"admin", "orderManager", "Java开发初级程序员"}, logical = Logical.OR)
    public ModelAndView findAllOrders() throws Exception {
        List<Orders> ordersList = ordersService.findAllOrders();
        ModelAndView modelAndView = new ModelAndView("pages/orders-page-list");
        modelAndView.addObject("ordersList", ordersList);
        return modelAndView;
    }

    @PostMapping("/deleteOrders")
    @RequiresPermissions("order:deleteOrder")
    @RequiresRoles(value = {"admin", "orderManager", "Java开发初级程序员"}, logical = Logical.OR)
    public String deleteOrders(@RequestParam(value = "ids") List<String> ids) throws Exception {
        System.out.println("11111111111111" + ids);
        for (String id : ids) {
            ordersService.deleteOrder(id);
        }
        return "redirect:/findAllOrders";
    }

    @PostMapping("/openOrders")
    @RequiresRoles(value = {"admin", "orderManager", "Java开发初级程序员"}, logical = Logical.OR)
    public String openOrders(@RequestParam(value = "ids") List<String> ids) throws Exception {
        System.out.println("openProducts*************" + ids);
        for (String id : ids) {
            ordersService.openOrder(ordersService.findOrderById(id));
        }
        return "redirect:/findAllOrders";
    }

    @PostMapping("/closeOrders")
    @RequiresRoles(value = {"admin", "orderManager", "Java开发初级程序员"}, logical = Logical.OR)
    public String closeOrders(@RequestParam(value = "ids") List<String> ids) throws Exception {
        System.out.println("closeProducts***********" + ids);
        for (String id : ids) {
            ordersService.closeOrder(ordersService.findOrderById(id));
        }
        return "redirect:/findAllOrders";
    }
}
