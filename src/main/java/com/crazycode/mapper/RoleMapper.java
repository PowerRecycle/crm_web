package com.crazycode.mapper;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * RoleMapper
 *
 * @author Administrator
 */
@Component
public interface RoleMapper extends Mapper<Role> {
    /**
     * findRoleDetailsById
     *
     * @param role
     * @return
     * @throws Exception
     */
    Role findRoleDetailsById(Role role) throws Exception;
}
