package com.crazycode.service;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;

import java.util.List;

/**
 * PermissionService
 *
 * @author Administrator
 */
public interface PermissionService {
    /**
     * 单个查询
     *
     * @param role
     * @return
     * @throws Exception
     */
    public List<Permission> findPermissionByRoleId(Role role) throws Exception;

    /**
     * 查询所有Permissions
     *
     * @return
     * @throws Exception
     */
    List<Permission> findAllPermissions() throws Exception;

    /**
     * 单个查询
     *
     * @param permission
     * @return
     * @throws Exception
     */
    Permission findPermissionById(Permission permission) throws Exception;

    /**
     * 增
     *
     * @param permission
     * @return
     * @throws Exception
     */
    int insertPermission(Permission permission) throws Exception;

    /**
     * 改
     *
     * @param permission
     * @return
     * @throws Exception
     */
    int updatePermission(Permission permission) throws Exception;

    /**
     * 删
     *
     * @param role
     * @return
     * @throws Exception
     */
    int deletePermission(Permission role) throws Exception;
}
