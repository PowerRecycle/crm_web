package com.crazycode.mapper;

import com.crazycode.pojo.Users;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;


/**
 * UsersMapper
 *
 * @author Administrator
 */
@Component
public interface UsersMapper extends Mapper<Users> {

    /**
     * 查询所有用户角色权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    Users findAllUsersAndRolesAndPermissionsByUserId(String id) throws Exception;



}
