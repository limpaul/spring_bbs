package com.board.www.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.service.BbsService;

@Controller
public class BoardController {
	private BbsService bbsService;
	
	@Autowired
	public BoardController(BbsService bbsService) {
		this.bbsService = bbsService;
	}
	
	@GetMapping(path="/list")
	public String list(HttpServletRequest request) {
		//bbsService.boardList(request);
		return "list";
	}

	@GetMapping("/list/{bbs_id}")
	public String content(@PathVariable("bbs_id")String bbsId ,Model model) {
		return "content";
	}
	@GetMapping(path = "/write")
	public String write(HttpServletRequest request, HttpServletResponse response) {
		String page = bbsService.writeSessionVerify(request, response);
		request.setAttribute("page", "write");
		return page;
	}
	@PostMapping(path="/writeAction")
	public String writeAction(Bbs bbs, HttpServletRequest request) {
		System.out.println(bbs.toString());
		HttpSession session = request.getSession();
		bbs.setUserID((String)session.getAttribute("userID"));
		bbsService.bbsWrite(bbs);
		return "redirect:list";
	}
	
}
