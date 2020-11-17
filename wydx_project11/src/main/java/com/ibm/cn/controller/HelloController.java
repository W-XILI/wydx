package com.ibm.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/tologin")
    public String index(){
        
        return "login";
    }
	
	@RequestMapping("/redirect")
	public String redi() {
		return "redirect:tologin";
	}

}
