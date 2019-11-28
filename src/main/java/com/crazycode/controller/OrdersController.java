package com.crazycode.controller;

import com.crazycode.pojo.Orders;
import com.crazycode.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("findOrderById/{id}")
    public ModelAndView findOrderById(@PathVariable String id) throws Exception {
        Orders orders = ordersService.findOrderById(id);
        ModelAndView modelAndView = new ModelAndView("pages/orders-show");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/findAllOrders")
    public ModelAndView findAllOrders() throws Exception {
        List<Orders> ordersList = ordersService.findAllOrders();
        ModelAndView modelAndView = new ModelAndView("pages/orders-page-list");
        modelAndView.addObject("ordersList", ordersList);
        return modelAndView;
    }
}
