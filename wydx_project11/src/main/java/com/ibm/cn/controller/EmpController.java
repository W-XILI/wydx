package com.ibm.cn.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

@Controller
@ResponseBody
public class EmpController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/findAllEmp")
	public List<Employee> getAllEmp() {
		List<Employee> emps = employeeService.findAllEmp();
		System.out.println(emps);
		return emps;
	}
	
	@PostMapping("/insertEmp")
	public String insertEmp(@RequestBody Employee emp) {
		employeeService.inserEmp(emp);
		return "添加成功";
	}
	
	@GetMapping("/del/{id}")
	public String delEmp(@PathVariable Integer id) {
		employeeService.delEmp(id);
		return "删除成功";
	}
	
	@PostMapping("/updataEmp")
	public String updataEmp(@RequestBody Employee emp) {
		employeeService.updataEmp(emp);
		return "更新成功";
	}
}	
