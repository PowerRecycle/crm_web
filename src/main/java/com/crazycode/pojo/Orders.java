package com.crazycode.pojo;

import lombok.Data;

@Data
public class Orders {

    private String id;
    private String orderNum;
    private String orderTime;
    private Long peopleCount;
    private String orderDesc;
    private Long payType;
    private Long orderStatus;
    private String productId;
    private String memberId;


}
