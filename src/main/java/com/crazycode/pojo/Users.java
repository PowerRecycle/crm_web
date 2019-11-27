package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import java.util.List;

/**
 * Users
 *
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
public class Users {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String email;
    private String username;
    private String password;
    // @Column(name = "phoneNum")
    private String phoneNum;
    private Long status;
    private List<Role> roleList = null;



}
