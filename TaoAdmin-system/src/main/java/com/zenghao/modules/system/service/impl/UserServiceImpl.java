/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.system.service.impl;

import com.zenghao.modules.system.domain.entity.User;
import com.zenghao.modules.system.repository.UserRepository;
import com.zenghao.modules.system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Override
	public void create(User resources) {
		userRepository.save(resources);
	}
}
