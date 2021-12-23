package com.board.www.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.www.bbs.dao.BbsDao;
import com.board.www.bbs.dao.IDao;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private BbsDao bbsDao;
	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("/removeContent")
	public String test(@RequestBody Map<String, String> removeBbs){
		// 게시판 아이디 
		int bbsID = Integer.parseInt(removeBbs.get("bbsID"));
		// 게시판 비밀번호
		String bbsSecret = removeBbs.get("bbsSecret");
		
		// mybatis로부터 쿼리 가져옴 게시판 번호랑, 아이디 반환 값 호출
		IDao dao = sqlSession.getMapper(IDao.class);
		Map<String, Object> bbs = dao.findBoardById(bbsID);
		
		// 해당 게시글이 db에 있는 경우 문자열 반환값 true를 반환 외에 false반환 
		if(bbs != null) {
			int bbsrID = (Integer) bbs.get("bbsID");
			String bbsrSecret = (String) bbs.get("bbsSecret");
			if(bbsID == bbsrID && bbsSecret.equals(bbsrSecret)) {
				dao.deleteBoard(bbsID);
				return "true";
			}
		}
		return "false";
	}
}
