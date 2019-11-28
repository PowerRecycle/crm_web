package com.crazycode.mapper;

import com.crazycode.pojo.RolePermission;
import com.crazycode.pojo.UsersRole;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * UsersRoleMapper
 *
 * @author Administrator
 */
@Component
public interface RolePermissionMapper extends Mapper<RolePermission> {
}
