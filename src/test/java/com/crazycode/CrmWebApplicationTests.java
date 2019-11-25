package com.crazycode;

import com.crazycode.pojo.Users;
import com.crazycode.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
class CrmWebApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UsersService usersService;

    @Test
    void contextLoads() throws Exception {
        // System.out.println(dataSource.getConnection());
        // for (Users allUser : usersService.findAllUsers()) {
        //     System.out.println(allUser);
        // }
        Users users = new Users();
        // users.setUsername("chenhao");
        // System.out.println(usersService.findUserByName(users));
        users.setEmail("111@163.com");
        users.setUsername("赵煜东");
        users = usersService.findUserByName(users);
        System.out.println(users);
        users.setPassword("123456");
        // users.setId(UUID.randomUUID().toString());
        // System.out.println(usersService.insertUser(users));
        System.out.println(usersService.updateUser(users));
        System.out.println(usersService.findUserByName(users));


    }

}
