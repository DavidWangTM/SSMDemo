package com.davidwang.dao;

import com.davidwang.model.User;

import java.util.Set;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByUsername(String username) ;

    Set<String> findRoles(String username) ;

    Set<String> findPermissions(String username) ;


}