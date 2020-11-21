package com.ibm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cn.entity.Employee;
import com.ibm.cn.service.EmployeeService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
@CrossOrigin
@Controller
@ResponseBody
public class HelloController {
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/tologin")
    public String index(){
        
        return "login";
    }
	
	@RequestMapping("/test")
	public Map<String, Object> test(Model model) {
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
		return result;
	}

}
