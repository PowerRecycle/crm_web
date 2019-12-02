package com.crazycode.service;

import com.crazycode.pojo.Users;

import java.util.List;

/**
 * UsersService
 *
 * @author Administrator
 */
public interface UsersService {
    /**
     * 查询所有用户角色权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    Users findAllUsersAndRolesAndPermissionsByUserId(String id) throws Exception;

    /**
     * 查询用户详情
     *
     * @param users
     * @return
     * @throws Exception
     */
    Users userDetails(Users users) throws Exception;

    /**
     * 查询所有Users
     *
     * @return
     * @throws Exception
     */
    List<Users> findAllUsers() throws Exception;

    /**
     * 单个查询:Id
     *
     * @param user
     * @return
     * @throws Exception
     */
    Users findUserById(Users user) throws Exception;

    /**
     * 单个查询:姓名
     *
     * @param user
     * @return
     * @throws Exception
     */
    Users findUserByName(Users user) throws Exception;

    /**
     * 增
     *
     * @param user
     * @return
     * @throws Exception
     */
    int insertUser(Users user) throws Exception;

    /**
     * 改
     *
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(Users user) throws Exception;

    /**
     * 删
     *
     * @param user
     * @return
     * @throws Exception
     */
    int deleteUser(Users user) throws Exception;
}
