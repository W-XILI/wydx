package com.ibm.cn.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/findAllEmp")
	public String getAllEmp(Model model) {
		List<Employee> emps = employeeService.findAllEmp();
		model.addAttribute("emps", emps);
		System.out.println(emps);
		return "show";
	}
	
	@PostMapping("/insertEmp")
	public String insertEmp(@RequestParam("name") String name,
							@RequestParam("age") Integer age,
							@RequestParam("salary") double salary) {
		System.out.println(name+age+salary);
		Employee emp = new Employee();
		emp.setAge(age);
		emp.setName(name);
		emp.setSalary(salary);
		employeeService.inserEmp(emp);
		
		return "redirect:findAllEmp";
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
	
	//去到添加页面
	@GetMapping("/toAddEmp")
	public String toAddEmp() {
		return "addEmp";
	}
	
	@GetMapping("/toUpdataEmp/{id}")
	public String toUpdataEmp(@PathVariable Integer id,
							  Model model) {
		Employee employee= employeeService.getEmpById(id);
		System.out.println(employee);
		return "index";
		
	}
}	
