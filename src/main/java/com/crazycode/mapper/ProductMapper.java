package com.crazycode.mapper;

import com.crazycode.pojo.Product;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Administrator
 */
@Component
public interface ProductMapper extends Mapper<Product> {
}
