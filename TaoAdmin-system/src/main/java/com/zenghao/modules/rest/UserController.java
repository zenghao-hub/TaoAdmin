/*
 *  Copyright 2021-2021 zenghao
 */
package com.zenghao.modules.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@GetMapping(value = "/test")
	public String test() {
		return "success";
	}
}
