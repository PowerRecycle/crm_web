package com.crazycode.mapper;

import com.crazycode.pojo.Traveller;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Component
public interface TravellerMapper extends Mapper<Traveller> {
    List<Traveller> findTravellersByOrderId(String orderId) throws Exception;
}
