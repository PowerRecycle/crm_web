package com.crazycode.service;

import com.crazycode.pojo.Product;

import java.util.List;

/**
 * ProductService
 *
 * @author Administrator
 */
public interface ProductService {
    /**
     * 查询全部Product
     *
     * @return
     * @throws Exception
     */
    List<Product> findAllProducts() throws Exception;

    /**
     * 单个查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    Product findProductById(String id) throws Exception;

    /**
     * 增
     *
     * @param product
     * @return
     * @throws Exception
     */
    int insertProduct(Product product) throws Exception;

    /**
     * 改
     *
     * @param product
     * @return
     * @throws Exception
     */
    int updateProduct(Product product) throws Exception;

    /**
     * 删
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteProduct(String id) throws Exception;
}
