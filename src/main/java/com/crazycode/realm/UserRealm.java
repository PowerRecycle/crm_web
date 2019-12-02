package com.crazycode.realm;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import com.crazycode.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UsersService usersService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("***********执行了授权方法***********");
        //封装授权的相关信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
        System.out.println("11111111111" + user);
        try {
            user = usersService.findAllUsersAndRolesAndPermissionsByUserId(user.getId());
            for (Role role : user.getRoleList()) {
                authorizationInfo.addRole(role.getRoleName());
                for (Permission permission : role.getPermissionList()) {
                    authorizationInfo.addStringPermission(permission.getPermissionName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("***********执行了认证方法***********");
        String username = (String) authenticationToken.getPrincipal();
        Users user = new Users();
        try {
            user = usersService.findUserByName(new Users(username));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException();
        }
        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), salt, "1024");
        return authenticationInfo;
    }
}
