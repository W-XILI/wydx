package com.ibm.cn.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cn.entity.User;
import com.ibm.cn.service.UserService;

@Controller
@ResponseBody
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {
		//先在数据库中查看该用户是否存在，存在则不可注册，不存在则注册
		User u = userService.findUser(user.getUsername(), user.getPassword());
		if(u==null) {
			userService.addUser(user);
			System.out.println("添加成功！");
		}else {
			System.out.println("该用户已存在");
		}
		
	}
	
	@PostMapping("/login")
	public void userlogin(@RequestBody User user) {
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
		String username = user.getUsername();
		String password = user.getPassword();
		User u = userService.findUser(username,password);
		System.out.println(u);
		if(u!=null) {
			System.out.println("登陆成功");
		}else {
			System.out.println("登陆失败");
		}
	}
	
	
	
}
