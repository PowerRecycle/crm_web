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
     * 查询所有Users
     *
     * @return
     * @throws Exception
     */
    List<Users> findAllUsers() throws Exception;

    /**
     * 单个查询
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
     * 查
     *
     * @param user
     * @return
     * @throws Exception
     */
    int deleteUser(Users user) throws Exception;
}
