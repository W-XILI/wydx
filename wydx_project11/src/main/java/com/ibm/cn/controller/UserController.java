package com.ibm.cn.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.entity.User;
import com.ibm.cn.service.EmployeeService;
import com.ibm.cn.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
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
	public String userlogin(@RequestParam("username") String username,
							@RequestParam("password") String password,
							Model model) {
		//查询出所有的员工信息
		List<Employee> emp = employeeService.findAllEmp();
		User u = userService.findUser(username,password);
		System.out.println(u);
		if(u!=null) {
			model.addAttribute("emps", emp);
			return "show";
		}else {
			model.addAttribute("error", "用户名或密码错误");
			return "login";
		}
	}
	
	
	
	
}
