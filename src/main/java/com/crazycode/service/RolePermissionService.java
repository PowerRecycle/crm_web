package com.crazycode.service;

import com.crazycode.pojo.RolePermission;

import java.util.List;

/**
 * RolePermission
 *
 * @author Administrator
 */
public interface RolePermissionService {


    /**
     * 查询所有RolePermissions
     *
     * @return
     * @throws Exception
     */
    List<RolePermission> findAllRolePermissions() throws Exception;

    /**
     * 查询
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    List<RolePermission> findRolePermissionByRoleId(RolePermission rolePermission) throws Exception;

    /**
     * 增
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    int insertRolePermission(RolePermission rolePermission) throws Exception;

    /**
     * 改
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    int updateRolePermission(RolePermission rolePermission) throws Exception;

    /**
     * 删
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    int deleteRolePermission(RolePermission rolePermission) throws Exception;
}
