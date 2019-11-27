package com.crazycode.controller;

import com.crazycode.pojo.Permission;
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
 * PermissionController
 *
 * @author Administrator
 */
@Controller
public class PermissionController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UsersRoleService usersRoleService;

    /**
     * 查找所有权限,并跳转到权限管理页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllPermissions")
    public ModelAndView findAllPermissions() throws Exception {
        List<Permission> permissions = permissionService.findAllPermissions();
        ModelAndView modelAndView = new ModelAndView("pages/permission-list");
        modelAndView.addObject("permissions", permissions);
        return modelAndView;
    }


}
