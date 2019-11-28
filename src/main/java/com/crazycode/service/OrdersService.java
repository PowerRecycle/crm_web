package com.crazycode.service;

import com.crazycode.pojo.Orders;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrdersService {
    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrders() throws Exception;

    /**
     * 单个查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    Orders findOrderById(String id) throws Exception;

    /**
     * 增
     *
     * @param order
     * @return
     * @throws Exception
     */
    int insertOrder(Orders order) throws Exception;

    /**
     * 改
     *
     * @param order
     * @return
     * @throws Exception
     */
    int updateOrder(Orders order) throws Exception;

    /**
     * 删
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteOrder(String id) throws Exception;


}
