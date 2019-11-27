package com.crazycode.controller;

import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import com.crazycode.pojo.UsersRole;
import com.crazycode.service.PermissionService;
import com.crazycode.service.RoleService;
import com.crazycode.service.UsersRoleService;
import com.crazycode.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * RoleController
 *
 * @author Administrator
 */
@Controller
public class RoleController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UsersRoleService usersRoleService;

    /**
     * 查找所有权限,并跳转到角色管理页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findRoleDetailsById/{id}")
    public ModelAndView findRoleDetailsById(@PathVariable String id) throws Exception {
        Role role = new Role();
        role.setId(id);
        role = roleService.findRoleDetailsById(role);
        ModelAndView modelAndView = new ModelAndView("pages/role-show");
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    /**
     * 查找所有权限,并跳转到角色管理页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllRoles2")
    public ModelAndView findAllRoles2() throws Exception {
        List<Role> allRoles = roleService.findAllRoles();
        ModelAndView modelAndView = new ModelAndView("pages/role-list");
        modelAndView.addObject("roles", allRoles);
        return modelAndView;
    }

    /**
     * 为用户添加角色
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
        for (String id : ids) {
            usersRole.setRoleId(id);
            usersRoleService.insertUsersRole(usersRole);
        }
        return "redirect:/usersList/1/5";
    }

    /**
     * 查找所有权限,并跳转到用户添加角色页面
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


}
