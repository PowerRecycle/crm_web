package com.crazycode.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
@Table(name = "users_role")
public class UsersRole {
    @Id
    private String userId;
    @Id
    private String roleId;

}
