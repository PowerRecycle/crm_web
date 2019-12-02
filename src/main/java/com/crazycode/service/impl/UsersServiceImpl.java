package com.crazycode.service.impl;

import com.crazycode.mapper.UsersMapper;
import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import com.crazycode.pojo.UsersRole;
import com.crazycode.service.PermissionService;
import com.crazycode.service.RoleService;
import com.crazycode.service.UsersRoleService;
import com.crazycode.service.UsersService;
import com.crazycode.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UsersServiceImpl
 *
 * @author Administrator
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UsersRoleService usersRoleService;

    /**
     * 查询所有用户角色权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Users findAllUsersAndRolesAndPermissionsByUserId(String id) throws Exception {
        return usersMapper.findAllUsersAndRolesAndPermissionsByUserId(id);
    }

    /**
     * 查询用户详情
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Users userDetails(Users user) throws Exception {
        user = usersService.findUserById(user);
        UsersRole usersRole = new UsersRole();
        //通过用户id获得List<UsersRole>
        usersRole.setUserId(user.getId());
        List<UsersRole> usersRoleList = usersRoleService.findUsersRoleById(usersRole);
        //创建List<Role>并遍历List<UsersRole>
        List<Role> roleList = new ArrayList<>();
        for (UsersRole usersRole1 : usersRoleList) {
            //通过RoleId获得Role
            Role role = new Role();
            role.setId(usersRole1.getRoleId());
            role = roleService.findRoleById(role);
            List<Permission> permissionList = permissionService.findPermissionByRoleId(role);
            role.setPermissionList(permissionList);
            //保存到List<Role>中
            roleList.add(role);
        }
        //将List<Role>保存到user中
        user.setRoleList(roleList);
        return user;
    }

    /**
     * 查询所有Users
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Users> findAllUsers() throws Exception {
        return usersMapper.selectAll();
    }

    /**
     * 单个查询:Id
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Users findUserById(Users user) throws Exception {
        return usersMapper.selectByPrimaryKey(user);
    }

    /**
     * 单个查询
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Users findUserByName(Users user) throws Exception {
        return usersMapper.selectOne(user);
    }

    /**
     * 增
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int insertUser(Users user) throws Exception {
        user.setPassword(MD5Util.md5Hash(user));
        return usersMapper.insert(user);
    }

    /**
     * 改
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updateUser(Users user) throws Exception {
        return usersMapper.updateByPrimaryKey(user);
    }

    /**
     * 删
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int deleteUser(Users user) throws Exception {
        return usersMapper.deleteByPrimaryKey(user);
    }

}
