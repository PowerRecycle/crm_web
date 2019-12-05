package com.crazycode.controller;

import com.crazycode.pojo.*;
import com.crazycode.service.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 角色添加权限"保存按钮"
     *
     * @param ids
     * @param roleId
     * @return
     * @throws Exception
     */
    @PostMapping("/addPermissionToRole")
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    public String addPermissionToRole(@RequestParam(value = "ids") List<String> ids, String roleId) throws Exception {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        //删除角色所有权限
        rolePermissionService.deleteRolePermission(rolePermission);
        //为用户添加角色
        for (String id : ids) {
            rolePermission.setPermissionId(id);
            rolePermissionService.insertRolePermission(rolePermission);
        }
        return "redirect:/findAllRoles2";
    }

    /**
     * 角色管理添加权限,添砖到添加权限页面
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/findRoleByIdAndAllPermission/{id}")
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    public ModelAndView findRoleByIdAndAllPermission(@PathVariable String id) throws Exception {
        Role role = new Role();
        role.setId(id);
        List<Permission> permissionList = permissionService.findAllPermissions();
        ModelAndView modelAndView = new ModelAndView("pages/role-permission-add");
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/deleteRole/{id}")
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    public String deleteRole(@PathVariable String id) throws Exception {
        Role role = new Role();
        role.setId(id);
        roleService.deleteRole(role);
        return "redirect:/findAllRoles2";
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    @PostMapping("/addRole")
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    public String addRole(Role role) throws Exception {
        roleService.insertRole(role);
        return "redirect:/findAllRoles2";
    }

    /**
     * 通过角色id查找角色和角色的所有权限,并跳转到角色详情页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findRoleDetailsById/{id}")
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    public ModelAndView findRoleDetailsById(@PathVariable String id) throws Exception {
        Role role = new Role();
        role.setId(id);
        role = roleService.findRoleDetailsById(role);
        ModelAndView modelAndView = new ModelAndView("pages/role-show");
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    /**
     * 查找所有角色,并跳转到角色管理页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllRoles2")
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    public ModelAndView findAllRoles2() throws Exception {
        List<Role> allRoles = roleService.findAllRoles();
        ModelAndView modelAndView = new ModelAndView("pages/role-list");
        modelAndView.addObject("roles", allRoles);
        return modelAndView;
    }


}
