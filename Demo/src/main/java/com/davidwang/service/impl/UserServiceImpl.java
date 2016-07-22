package com.davidwang.service.impl;

import com.davidwang.dao.UserMapper;
import com.davidwang.model.User;
import com.davidwang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}


	public User findUserByUsername(String name) {
		User user = userMapper.findUserByUsername(name);
		return user;
	}

	public Set<String> findRoles(String name) {
		return userMapper.findRoles(name);
	}

	public Set<String> findPermissions(String name) {
		return userMapper.findPermissions(name);
	}




}
