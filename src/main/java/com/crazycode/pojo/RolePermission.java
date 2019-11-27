package com.crazycode.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NameStyle(Style.normal)
@Table(name = "role_permission")
public class RolePermission {
    @Id
    private String permissionId;
    @Id
    private String roleId;


}
