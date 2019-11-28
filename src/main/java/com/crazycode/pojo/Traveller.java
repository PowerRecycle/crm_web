package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;

@Data
@NameStyle(Style.normal)
public class Traveller {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Long credentialsType;
    private String credentialsNum;
    private Long travellerType;


}
