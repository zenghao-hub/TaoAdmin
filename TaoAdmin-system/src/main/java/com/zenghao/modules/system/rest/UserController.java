/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.system.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@GetMapping(value = "/test")
	public ResponseEntity<Object> test() {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}
