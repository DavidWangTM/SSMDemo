package com.davidwang.service.impl;

import com.davidwang.dao.UserMapper;
import com.davidwang.model.User;
import com.davidwang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
//
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
