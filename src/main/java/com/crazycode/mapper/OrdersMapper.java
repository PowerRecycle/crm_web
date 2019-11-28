package com.crazycode.mapper;

import com.crazycode.pojo.Orders;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * OrdersMapper
 *
 * @author Administrator
 */
@Component
public interface OrdersMapper extends Mapper<Orders> {
    /**
     * 查找所有订单及产品
     *
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrdersAndProducts() throws Exception;

    /**
     * 通过订单id查找订单及产品及会员及游客
     *
     * @param id
     * @return
     * @throws Exception
     */
    Orders findOrderAndProductsAndMembersAndTravellersByOrderId(String id) throws Exception;
}
