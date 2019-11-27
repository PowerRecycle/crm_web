package com.crazycode.mapper;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * PermissionMapper
 *
 * @author Administrator
 */
@Component
public interface PermissionMapper extends Mapper<Permission> {
    /**
     * selectPermissionByRoleId
     *
     * @param role
     * @return
     * @throws Exception
     */
    List<Permission> selectPermissionByRoleId(Role role) throws Exception;
}
