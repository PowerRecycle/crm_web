package com.crazycode.service.impl;

import com.crazycode.mapper.PermissionMapper;
import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import com.crazycode.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 单个查询
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findPermissionByRoleId(Role role) throws Exception {
        return permissionMapper.selectPermissionByRoleId(role);
    }

    /**
     * 查询所有Permissions
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAllPermissions() throws Exception {
        return permissionMapper.selectAll();
    }

    /**
     * 单个查询
     *
     * @param permission
     * @return
     * @throws Exception
     */
    @Override
    public Permission findPermissionById(Permission permission) throws Exception {
        return permissionMapper.selectByPrimaryKey(permission);
    }

    /**
     * 增
     *
     * @param permission
     * @return
     * @throws Exception
     */
    @Override
    public int insertPermission(Permission permission) throws Exception {
        return permissionMapper.insert(permission);
    }

    /**
     * 改
     *
     * @param permission
     * @return
     * @throws Exception
     */
    @Override
    public int updatePermission(Permission permission) throws Exception {
        return permissionMapper.updateByPrimaryKey(permission);
    }

    /**
     * 删
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public int deletePermission(Permission role) throws Exception {
        return permissionMapper.deleteByPrimaryKey(permissionMapper);
    }
}
