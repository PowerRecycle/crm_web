package com.crazycode.init;

import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 当程序一加载,实现ApplicationRunner对象的run方法也会跟着执行
 *
 * @author Administrator
 */
@Component
@Order(1)
public class ProductRunner implements ApplicationRunner {
    @Autowired
    private ProductService productService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("init......");
        //查询并创建索引库
        productService.createProductIndex();

    }
}
