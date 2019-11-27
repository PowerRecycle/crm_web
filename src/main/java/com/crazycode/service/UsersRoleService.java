package com.crazycode.service;

import com.crazycode.pojo.UsersRole;

import java.util.List;

/**
 * RoleService
 *
 * @author Administrator
 */
public interface UsersRoleService {


    /**
     * 查询所有UsersRoles
     *
     * @return
     * @throws Exception
     */
    List<UsersRole> findAllUsersRoles() throws Exception;

    /**
     * 查询
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    List<UsersRole> findUsersRoleById(UsersRole usersRole) throws Exception;

    /**
     * 增
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    int insertUsersRole(UsersRole usersRole) throws Exception;

    /**
     * 改
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    int updateUsersRole(UsersRole usersRole) throws Exception;

    /**
     * 删
     *
     * @param usersRole
     * @return
     * @throws Exception
     */
    int deleteUsersRole(UsersRole usersRole) throws Exception;
}
