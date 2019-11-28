package com.crazycode.service.impl;

import com.crazycode.mapper.UsersRoleMapper;
import com.crazycode.pojo.UsersRole;
import com.crazycode.service.UsersRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UsersRoleServiceImpl
 *
 * @author Administrator
 */
@Service
public class UsersRoleServiceImpl implements UsersRoleService {
    @Autowired
    private UsersRoleMapper usersRoleMapper;


    /**
     * 查询所有UsersRoles
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<UsersRole> findAllUsersRoles() throws Exception {
        return usersRoleMapper.selectAll();
    }

    /**
     * 查询
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    @Override
    public List<UsersRole> findUsersRoleById(UsersRole usersRole) throws Exception {
        return usersRoleMapper.select(usersRole);
    }

    /**
     * 增
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    @Override
    public int insertUsersRole(UsersRole usersRole) throws Exception {
        return usersRoleMapper.insert(usersRole);
    }

    /**
     * 改
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    @Override
    public int updateUsersRole(UsersRole usersRole) throws Exception {
        return usersRoleMapper.updateByPrimaryKey(usersRole);
    }

    /**
     * 删
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    @Override
    public int deleteUsersRole(UsersRole usersRole) throws Exception {
        return usersRoleMapper.delete(usersRole);
    }
}
