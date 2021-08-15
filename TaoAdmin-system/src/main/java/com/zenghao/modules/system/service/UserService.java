package com.zenghao.modules.system.service;

import com.zenghao.modules.system.domain.entity.User;

public interface UserService {
	/**
	 * 创建用户
	 *
	 * @param resources 用户信息
	 */
	void create(User resources);
}
