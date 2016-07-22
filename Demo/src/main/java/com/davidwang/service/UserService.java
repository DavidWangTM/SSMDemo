package com.davidwang.service;

import com.davidwang.model.User;

import java.util.Set;

/**
 * Created by DavidWang on 16/7/20.
 */
public interface UserService {

    public User getUserById(int i);


    /**
     * Shiro的登录验证，通过用户名查询用户信息
     * @param username
     * @return
     */
    public User findUserByUsername(String username) ;

    /**
     * 根据账号查找角色名称
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) ;

    /**
     * 根据账号查找权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) ;

}
