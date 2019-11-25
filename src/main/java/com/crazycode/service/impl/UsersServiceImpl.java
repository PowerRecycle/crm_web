package com.crazycode.service.impl;

import com.crazycode.mapper.UsersMapper;
import com.crazycode.pojo.Users;
import com.crazycode.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
