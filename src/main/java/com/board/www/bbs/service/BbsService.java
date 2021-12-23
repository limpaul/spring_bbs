package com.board.www.bbs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.dto.User;
import com.board.www.bbs.repository.BoardRepository;
import com.board.www.bbs.repository.UserRepository;

@Service
public class BbsService {
	private UserRepository userRepository;
	private BoardRepository boardRepository;
	public BbsService() {

	}
	
	@Autowired
	public BbsService(UserRepository userRepository, BoardRepository boardRepository) {
		this.userRepository = userRepository;
		this.boardRepository = boardRepository;
	}
	/*
	 	session이 있지 않고 작성 페이지에 들어갈시에 로그인 페이지 이동.
	 */
	public String writeSessionVerify(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String page = null;
		if(session.getAttribute("userID") == null){
			System.out.println("session 값이 없어서?");
			page = "login";
		}else {
			page = "write";
		}
		return page;
	}
	public void userJoinAction(User user) {
		userRepository.joinAction(user);
	}

	public String userLoginAction(String userID, String userPassword, String viewPage, HttpServletRequest request) {
	
		int result = userRepository.loginAction(userID, userPassword);
		/*
		 * 1. 작성 페이지 2. 메인 페이지 3. 그외 로그인 페이지
		 */
		if (result == 1 && viewPage.equals("write")) {
			System.out.println("write.board Page이동!");
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			viewPage = "write";

		} else if (result == 1 && viewPage.equals("main")) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			viewPage = "main";
		} else {
			viewPage ="login";
		}
		return viewPage;
	}
	public void boardList(HttpServletRequest request) {
		List<Bbs> list = boardRepository.freeListPage();
		request.setAttribute("list", list);
	}
	public String bbsWrite(Bbs bbs) {
		int result = boardRepository.bbsWrite(bbs);
		if(result == 1) {
			return "redirect:list";
		}else {
			return "write";
		}
	}
	public Bbs updateBbs(int bbsID, Model model) {
		Bbs bbs = boardRepository.findById(bbsID);
		model.addAttribute("bbs", bbs);
		return bbs;
	}
	
}
