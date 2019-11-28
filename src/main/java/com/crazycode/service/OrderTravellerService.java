package com.crazycode.service;

import com.crazycode.pojo.OrderTraveller;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrderTravellerService {
    /**
     * 通过订单id查找OrderTraveller
     * @param OrderId
     * @return
     * @throws Exception
     */
    List<OrderTraveller> findOrderTravellersByOrderId(String OrderId) throws Exception;
}
