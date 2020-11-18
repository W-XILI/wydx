package com.ibm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Controller
public class HelloController {
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/tologin")
    public String index(){
        
        return "login";
    }
	
	@RequestMapping("/test")
	public String test(Model model) {
		List<Employee> emps = employeeService.findAllEmp();
		JSONArray json = JSONArray.fromObject(emps);
		System.out.println(json);
		model.addAttribute("json", json);
		model.addAttribute("list", emps);
		System.out.println(emps);
		
		return "index";
	}

}
