package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;

@Data
@NameStyle(Style.normal)
public class Syslog {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String visitTime;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;


}
