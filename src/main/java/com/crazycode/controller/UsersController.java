package com.crazycode.controller;

import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import com.crazycode.pojo.UsersRole;
import com.crazycode.service.RoleService;
import com.crazycode.service.UsersRoleService;
import com.crazycode.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 控制层UsersController
 *
 * @author Administrator
 */
@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UsersRoleService usersRoleService;

    /**
     * "保存"按钮:用户添加角色
     *
     * @param ids
     * @param userId
     * @return
     * @throws Exception
     */
    @PostMapping("/addRoleToUser")
    public String addUserRole(@RequestParam(value = "ids") List<String> ids, String userId) throws Exception {
        UsersRole usersRole = new UsersRole();
        usersRole.setUserId(userId);
        //删除用户所有角色
        usersRoleService.deleteUsersRole(usersRole);
        //为用户添加角色
        for (String id : ids) {
            usersRole.setRoleId(id);
            usersRoleService.insertUsersRole(usersRole);
        }
        return "redirect:/usersList/1/5";
    }

    /**
     * "添加角色":通过用户id查找该用户角色,为用户管理添加角色,并跳转到用户添加角色页面
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllRoles/{id}")
    public ModelAndView findAllRoles(@PathVariable String id) throws Exception {
        List<Role> allRoles = roleService.findAllRoles();
        ModelAndView modelAndView = new ModelAndView("pages/user-role-add");
        modelAndView.addObject("roles", allRoles);
        Users users = new Users();
        users.setId(id);
        modelAndView.addObject("user", users);
        return modelAndView;
    }

    /**
     * 添加用户
     *
     * @param users
     * @return
     * @throws Exception
     */
    @PostMapping("/addUser")
    public String addUser(Users users) throws Exception {
        usersService.insertUser(users);
        return "redirect:/usersList/1/5";
    }

    /**
     * 查询用户详情
     *
     * @param user
     * @return
     * @throws Exception
     */
    @GetMapping("/userDetails/{id}")
    public ModelAndView userDetails(Users user) throws Exception {
        user = usersService.userDetails(user);
        ModelAndView modelAndView = new ModelAndView("pages/user-show1");
        modelAndView.addObject("userDetails", user);
        return modelAndView;
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/usersList/{pageNum}/{pageSize}")
    public ModelAndView usersList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, HttpSession session) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> allUsers = usersService.findAllUsers();
        PageInfo<Users> pageInfo = new PageInfo<>(allUsers);
        ModelAndView modelAndView = new ModelAndView("pages/user-list");
        modelAndView.addObject("users", allUsers);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    /**
     * 登录
     *
     * @param user
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/login.do")
    public ModelAndView login(Users user, HttpSession session) throws Exception {
        Users userByName = usersService.findUserByName(user);
        ModelAndView modelAndView = new ModelAndView();
        if (userByName != null) {
            modelAndView.setViewName("pages/main");
            session.setAttribute("user", userByName);
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}

