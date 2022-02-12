package com.board.www.bbs.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.www.bbs.dto.BbsRecommend;
import com.board.www.bbs.dto.Review;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.board.www.bbs.config.AppConfig.class)
public class ApiServiceTest {
	private ApiService apiService;

	@Autowired
	private SqlSession sqlSession;
	@Before
	public void init() {
		apiService = new ApiService(sqlSession);
		
	}
	
//	@Test
//	public void getList() {
//		apiService.getBoardList(0).forEach(it -> System.out.println(it.toString()));
//	}
	@Test
	public void getList() {
		System.out.println(apiService.getBoardList(0).toString());;
	}
	@Test
	public void getReviewList() {
		//getReviewList("게시판번호", "리뷰 시작페이지", "리뷰 데이터 개수")
		apiService.getReviewList(1, 0, 10).forEach(it -> System.out.println(it.toString()));
	}
	@Ignore
	@Test
	public void writeReviewTest() {
		Review review = new Review();
		review.setUserId("test");
		review.setReviewContent("fun fun life");
		apiService.writeReview(3, review);
		
		apiService.getReviewList(3, 0, 5).forEach(it -> System.out.println(it.toString()));
	}
	@Test
	public void recommendTest() { // 좋아요 또는 싫어요 로그 조회.
		BbsRecommend rmd = new BbsRecommend();
		rmd.setUserId("test"); // test라는 계정이 1번 게시글이 추천 또는 비추천을 눌렀는가?
		apiService.findRecommendById(1, rmd);
	
	}
	@Ignore
	@Test
	public void pushRecommend() { // 좋아요 싫어요 눌렀을 때 db가 동작을 하는가?
		BbsRecommend rmd = new BbsRecommend();
		rmd.setUserId("toto");
		rmd.setPostive(1); // 추천 눌렀음 
		rmd.setNegative(0);
		apiService.addRecommend(1, rmd);
	}
	@Test
	public void bbsCountTest() {
		int result = apiService.getBbsCount(5);
		System.out.println(result);
	}
	
	@Test
	public void getCountTest() {
		int result = apiService.getBbsCount(5);
		System.out.println(result);
	}
	
	@Test
	public void getReviewCountTest() {
		int result = apiService.getBbsReviewCount(1, 5);
		System.out.println(result);
	}
	
}
