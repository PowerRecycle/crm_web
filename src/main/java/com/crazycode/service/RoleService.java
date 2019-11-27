package com.crazycode.service;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;

import java.util.List;

/**
 * RoleService
 *
 * @author Administrator
 */
public interface RoleService {
    /**
     * 通过角色id查找角色详情
     *
     * @param role
     * @return
     * @throws Exception
     */
    Role findRoleDetailsById(Role role) throws Exception;

    /**
     * 查询所有Roles
     *
     * @return
     * @throws Exception
     */
    List<Role> findAllRoles() throws Exception;

    /**
     * 单个查询
     *
     * @param role
     * @return
     * @throws Exception
     */
    Role findRoleById(Role role) throws Exception;

    /**
     * 增
     *
     * @param role
     * @return
     * @throws Exception
     */
    int insertRole(Role role) throws Exception;

    /**
     * 改
     *
     * @param role
     * @return
     * @throws Exception
     */
    int updateRole(Role role) throws Exception;

    /**
     * 删
     *
     * @param role
     * @return
     * @throws Exception
     */
    int deleteRole(Role role) throws Exception;
}
