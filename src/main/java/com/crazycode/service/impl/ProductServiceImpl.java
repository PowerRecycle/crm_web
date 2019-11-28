package com.crazycode.service.impl;

import com.crazycode.mapper.ProductMapper;
import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl
 *
 * @author Administrator
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询全部Product
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAllProducts() throws Exception {
        return productMapper.selectAll();
    }

    /**
     * 单个查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Product findProductById(String id) throws Exception {
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * 增
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int insertProduct(Product product) throws Exception {
        return productMapper.insert(product);
    }

    /**
     * 改
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int updateProduct(Product product) throws Exception {
        return productMapper.updateByPrimaryKey(product);
    }

    /**
     * 删
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteProduct(String id) throws Exception {
        return productMapper.deleteByPrimaryKey(id);
    }
}
