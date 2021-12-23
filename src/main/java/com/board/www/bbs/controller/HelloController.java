package com.board.www.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	
	//@GetMapping @PostMapping @PutMapping @DeleteMappiong 
	@GetMapping("/hello")
	public String hello() {
		return "main";
	}

}
