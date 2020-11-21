package com.ibm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

import net.sf.json.JSONArray;
@CrossOrigin
@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/findAllEmp")
	public String getAllEmp(Model model) {
		List<Employee> emps = this.employeeService.findAllEmp();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", " ");
		result.put("count", 100);
		JSONArray array = JSONArray.fromObject(emps);
		result.put("data", array);	
//		model.addAttribute("emps", emps);
		
		model.addAttribute("result",result);
		System.out.println(emps);
		System.out.println(result);
		return "employeeList";
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
	@ResponseBody
	public Object delEmp(@PathVariable Integer id) {
		employeeService.delEmp(id);
		Map<String, String> responseMap=new HashMap<String, String>();
		responseMap.put("info", "deleted success");
		return responseMap;
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
	@ResponseBody
	public Object toUpdataEmp(@PathVariable Integer id) {
		Employee employee= employeeService.getEmpById(id);
		Map<String, String> responseMap=new HashMap<String, String>();
		responseMap.put("info", "update success");
		return responseMap;
		
	}
}	
