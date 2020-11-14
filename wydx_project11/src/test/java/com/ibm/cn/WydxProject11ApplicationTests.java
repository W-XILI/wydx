package com.ibm.cn;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.cn.entity.User;
import com.ibm.cn.service.BookService;
import com.ibm.cn.service.UserService;

@SpringBootTest
class WydxProject11ApplicationTests {
	
	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
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


