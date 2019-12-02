package com.crazycode.config;

import com.crazycode.realm.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Configuration
public class ShiroConfig {
    /**
     * 在容器中创建一个UserRealm对象
     *
     * @return
     * @throws Exception
     */
    @Bean
    public UserRealm userRealm(CredentialsMatcher hashedCredentialsMatcher) throws Exception {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }

    /**
     * 在容器中装配securityManager对象
     *
     * @param userRealm
     * @return
     * @throws Exception
     */
    @Bean
    public SessionsSecurityManager securityManager(Realm userRealm) throws Exception {
        SessionsSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() throws Exception {
        DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // filterChainDefinitionMap.put("/index", "anon");
        // filterChainDefinitionMap.put("/login", "anon");
        // filterChainDefinitionMap.put("/login.jsp", "anon");
        filterChainDefinitionMap.put("/login.do", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/pages/product*", "roles[productManager]");
        filterChainDefinitionMap.put("/pages/order*", "roles[orderManager]");
        filterChainDefinitionMap.put("/**", "roles[admin]");
        filterChainDefinitionMap.put("/", "permissions[order:deleteOrder]");
        filterChainDefinitionMap.put("/", "permissions[product:add]");
        filterChainDefinitionMap.put("/", "permissions[order:deleteOrder1]");
        filterChainDefinitionMap.put("/", "permissions[product:delete]");
        filterChainDefinitionMap.put("/findAllOrders", "permissions[order:queryOrdersInfo]");
        filterChainDefinitionMap.put("/findOrderById/**", "permissions[order:queryOrdersInfo]");
        shiroFilterChainDefinition.addPathDefinitions(filterChainDefinitionMap);
        return shiroFilterChainDefinition;
    }

    /**
     * 配置一个CredentialsMatcher密码匹配器,当调用自定义realm的时候
     * 会把表单传过来的数据密码交给HashedCredentialsMatcher来进行加密
     * 加密后和数据库中的密码进行比对
     *
     * @return
     * @throws Exception
     */
    @Bean
    public CredentialsMatcher hashedCredentialsMatcher() throws Exception {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法类型
        credentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        //设置加密次数
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }
}
