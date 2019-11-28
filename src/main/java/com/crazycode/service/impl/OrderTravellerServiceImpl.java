package com.crazycode.service.impl;

import com.crazycode.mapper.OrderTravellerMapper;
import com.crazycode.pojo.OrderTraveller;
import com.crazycode.service.OrderTravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class OrderTravellerServiceImpl implements OrderTravellerService {
    @Autowired
    private OrderTravellerMapper orderTravellerMapper;
    @Autowired
    private OrderTraveller orderTraveller;

    /**
     * 通过订单id查找OrderTraveller
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @Override
    public List<OrderTraveller> findOrderTravellersByOrderId(String orderId) throws Exception {
        orderTraveller.setOrderId(orderId);
        return orderTravellerMapper.select(orderTraveller);
    }
}
