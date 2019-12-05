package com.crazycode.controller;

import com.crazycode.pojo.Permission;
import com.crazycode.service.PermissionService;
import com.crazycode.service.RoleService;
import com.crazycode.service.UsersRoleService;
import com.crazycode.service.UsersService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private PermissionService permissionService;

    /**
     * 删除权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/deletePermission/{id}")
    @RequiresRoles("admin")
    public String deletePermission(@PathVariable String id) throws Exception {
        Permission permission = new Permission();
        permission.setId(id);
        permissionService.deletePermission(permission);
        return "redirect:/findAllPermissions";
    }

    /**
     * 添加权限
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/addPermission")
    @RequiresRoles("admin")
    public String addPermission(Permission permission) throws Exception {
        permissionService.insertPermission(permission);
        return "redirect:/findAllPermissions";
    }

    /**
     * 权限详情,根据角色id查找该角色所有权限详情,并跳转到权限详情页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findPermissionDetailsById/{id}")
    @RequiresRoles("admin")
    public ModelAndView findPermissionDetailsById(@PathVariable String id) throws Exception {
        Permission permission = new Permission();
        permission.setId(id);
        permission = permissionService.findPermissionById(permission);
        ModelAndView modelAndView = new ModelAndView("pages/permission-show");
        modelAndView.addObject("permission", permission);
        return modelAndView;
    }

    /**
     * 查找所有权限,并跳转到权限管理页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllPermissions")
    @RequiresRoles("admin")
    public ModelAndView findAllPermissions() throws Exception {
        List<Permission> permissions = permissionService.findAllPermissions();
        ModelAndView modelAndView = new ModelAndView("pages/permission-list");
        modelAndView.addObject("permissions", permissions);
        return modelAndView;
    }


}
