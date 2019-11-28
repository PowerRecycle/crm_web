package com.crazycode.service.impl;

import com.crazycode.mapper.RolePermissionMapper;
import com.crazycode.pojo.RolePermission;
import com.crazycode.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RolePermissionServiceImpl
 *
 * @author Administrator
 */

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * 查询所有RolePermissions
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<RolePermission> findAllRolePermissions() throws Exception {
        return rolePermissionMapper.selectAll();
    }

    /**
     * 查询
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    @Override
    public List<RolePermission> findRolePermissionByRoleId(RolePermission rolePermission) throws Exception {
        return rolePermissionMapper.select(rolePermission);
    }

    /**
     * 增
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    @Override
    public int insertRolePermission(RolePermission rolePermission) throws Exception {
        return rolePermissionMapper.insert(rolePermission);
    }

    /**
     * 改
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    @Override
    public int updateRolePermission(RolePermission rolePermission) throws Exception {
        return rolePermissionMapper.updateByPrimaryKey(rolePermission);
    }

    /**
     * 删
     *
     * @param rolePermission
     * @return
     * @throws Exception
     */
    @Override
    public int deleteRolePermission(RolePermission rolePermission) throws Exception {
        return rolePermissionMapper.delete(rolePermission);
    }
}
