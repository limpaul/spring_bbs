package com.board.www.bbs.controller;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.dto.Review;
import com.board.www.bbs.service.ApiService;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("/removeContent")
	public String test(@RequestBody Map<String, String> data){
		System.out.println(data);
		return apiService.removeBbs(data);
	}
	@GetMapping("/bbs/{bbsId}")
	public Bbs getBoard(@PathVariable int bbsId) {
		return apiService.findBoardById(bbsId);
	}
	
	
	
	@GetMapping("/bbs_list")
	public List<Bbs> freeListPage() {
		return apiService.getBoardList();
	}
	@GetMapping("/review/{bbs_id}")
	public List<Review> reviewList(@PathVariable("bbs_id") int bbsId){
		return apiService.getReviewList(bbsId);
	}
	// 댓글 작성 
	@PostMapping("/review/{bbsId}")
	public String writeReview(@PathVariable int bbsId 
			,@RequestBody Review review) {
		apiService.writeReview(bbsId, review);
		return "{}";
	}
	
}
