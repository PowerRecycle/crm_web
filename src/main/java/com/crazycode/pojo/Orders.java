package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import java.util.List;

/**
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
public class Orders {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String orderNum;
    private String orderTime;
    private Long peopleCount;
    private String orderDesc;
    private Long payType;
    private Long orderStatus;
    private String productId;
    private String memberId;
    private Product product;
    private Member member;
    private List<Traveller> travellers;

}
