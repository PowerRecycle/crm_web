package com.crazycode.pojo;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    private String departureTime;
    private Double productPrice;
    private String productDesc;
    private Long productStatus;


}
