package com.board.www.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.www.bbs.dto.User;
import com.board.www.bbs.service.BbsService;
@Controller
public class UserController {
	@Autowired
	private BbsService bbsService;
	
	@GetMapping(path = "/main")
	public String main() {
		return "main";
	}
	
	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(path="/loginAction")
	public String loginAction(@RequestParam("userID") String userID,
							  @RequestParam("userPassword") String userPassword,
							  @RequestParam("page") String page,
							  HttpServletRequest request) {
		
		String movePage = bbsService.userLoginAction(userID, userPassword, page, request);
		return movePage;
	}
	
	@GetMapping(path = "/join")
	public String join() {
		return "join";
	}
	
	@PostMapping(path="/joinAction")
	public String joinAction(User user) {
		bbsService.userJoinAction(user);
		return "redirect:main";
	}
	
	@RequestMapping(path="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("userID");
		return "main";
	}
}
