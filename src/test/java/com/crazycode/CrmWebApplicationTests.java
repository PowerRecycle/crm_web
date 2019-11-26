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
    void contextLoads2() throws Exception {

        for (int i = 0; i < 20; i++) {
            Users users = new Users();
            users.setEmail("113" + i + "@163.com");
            users.setUsername("赵煜东3" + i);
            usersService.insertUser(users);
        }

    }


    @Test
    void contextLoads() throws Exception {
        // System.out.println(dataSource.getConnection());
        for (Users allUser : usersService.findAllUsers()) {
            System.out.println(allUser);
        }
        for (int i = 0; i < 20; i++) {
            Users users = new Users();
            users.setEmail("113" + i + "@163.com");
            users.setUsername("赵煜东3" + i);
            usersService.insertUser(users);
        }
        System.out.println("**********************************************");
        Users users = new Users();
        // users.setUsername("chenhao");
        // System.out.println(usersService.findUserByName(users));
        users.setEmail("113@163.com");
        users.setUsername("赵煜东3");
        // users = usersService.findUserByName(users);
        // System.out.println(users);
        users.setPassword("123456");
        // users.setId(UUID.randomUUID().toString());
        System.out.println(users);
        System.out.println("插入" + usersService.insertUser(users));
        System.out.println(users);
        System.out.println("插入后" + usersService.findUserByName(users));
        users.setPassword("654321");
        System.out.println("更新" + usersService.updateUser(users));
        System.out.println("更新后" + usersService.findUserByName(users));
        System.out.println("删除" + usersService.deleteUser(users));
        System.out.println("**********************************************");
        // System.out.println(dataSource.getConnection());
        for (Users allUser : usersService.findAllUsers()) {
            System.out.println(allUser);
        }


    }

}
