package com.crazycode.service.impl;

import com.crazycode.mapper.PermissionMapper;
import com.crazycode.mapper.RoleMapper;
import com.crazycode.mapper.UsersRoleMapper;
import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import com.crazycode.pojo.UsersRole;
import com.crazycode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * RoleServiceImpl
 *
 * @author Administrator
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UsersRoleMapper usersRoleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * findRoleDetailsById
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public Role findRoleDetailsById(Role role) throws Exception {
        return roleMapper.findRoleDetailsById(role);
    }

    /**
     * 查询所有Roles
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAllRoles() throws Exception {
        return roleMapper.selectAll();
    }

    /**
     * 单个查询
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public Role findRoleById(Role role) throws Exception {
        return roleMapper.selectByPrimaryKey(role);
    }

    /**
     * 增
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public int insertRole(Role role) throws Exception {
        return roleMapper.insert(role);
    }

    /**
     * 改
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public int updateRole(Role role) throws Exception {
        return roleMapper.updateByPrimaryKey(role);
    }

    /**
     * 删
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public int deleteRole(Role role) throws Exception {
        return roleMapper.deleteByPrimaryKey(role);
    }
}
