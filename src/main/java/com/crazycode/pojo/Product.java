package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;

/**
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
public class Product {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    private String departureTime;
    private Double productPrice;
    private String productDesc;
    private Long productStatus;


}
