package com.crazycode.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
@Table(name = "order_traveller")
@Component
public class OrderTraveller {
    @Id
    private String orderId;
    @Id
    private String travellerId;


}
