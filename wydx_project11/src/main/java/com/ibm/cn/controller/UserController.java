package com.ibm.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.cn.entity.User;
import com.ibm.cn.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public void addUser(@RequestParam User user) {
		User u = new User();
		u.setId(1);
		u.setSex("男");
		u.setPassword("123");
		u.setRealname("MUKE");
		u.setUsername("TT");
		userService.addUser(u);
		System.out.println("添加成功！");
	}
	
}
