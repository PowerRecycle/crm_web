package com.crazycode.service.impl;

import com.crazycode.mapper.OrdersMapper;
import com.crazycode.mapper.ProductMapper;
import com.crazycode.pojo.Orders;
import com.crazycode.pojo.Product;
import com.crazycode.service.OrdersService;
import com.crazycode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ProductService productService;

    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAllOrders() throws Exception {
        return ordersMapper.findAllOrdersAndProducts();
    }

    /**
     * 单个查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Orders findOrderById(String id) throws Exception {
        return ordersMapper.findOrderAndProductsAndMembersAndTravellersByOrderId(id);
    }

    /**
     * 增
     *
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int insertOrder(Orders order) throws Exception {
        return ordersMapper.insert(order);
    }

    /**
     * 改
     *
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int updateOrder(Orders order) throws Exception {
        return ordersMapper.updateByPrimaryKey(order);
    }

    /**
     * 删
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteOrder(String id) throws Exception {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    /**
     * 开启
     *
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int openOrder(Orders order) throws Exception {
        order.setOrderStatus(1L);
        return ordersMapper.updateByPrimaryKey(order);
    }

    /**
     * 关闭
     *
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public int closeOrder(Orders order) throws Exception {
        order.setOrderStatus(0L);
        return ordersMapper.updateByPrimaryKey(order);
    }
}
