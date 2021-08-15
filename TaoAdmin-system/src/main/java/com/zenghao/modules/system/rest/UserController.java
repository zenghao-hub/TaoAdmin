/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.system.rest;

import com.zenghao.modules.system.domain.entity.User;
import com.zenghao.modules.system.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "系统：用户管理")
@RestController
@RequestMapping("/api/users")
public class UserController {
//	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/test")
	public ResponseEntity<Object> test() {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation("新增用户")
	@PostMapping
	public ResponseEntity<Object> create(@Validated @RequestBody User resources){
		// 默认密码 123456
//		resources.setPassword(passwordEncoder.encode("123456"));
		userRepository.save(resources);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
