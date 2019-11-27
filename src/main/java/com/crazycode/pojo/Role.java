package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import java.util.List;

/**Role
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
public class Role {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissionList = null;

}
