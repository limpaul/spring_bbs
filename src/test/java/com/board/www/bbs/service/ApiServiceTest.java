package com.board.www.bbs.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	@Test
	public void getList() {
		apiService.getBoardList().forEach(it -> System.out.println(it.toString()));
	}
	@Test
	public void getReviewList() {
		apiService.getReviewList(1).forEach(it -> System.out.println(it.toString()));
	}
	@Ignore
	@Test
	public void writeReviewTest() {
		Review review = new Review();
		review.setUserId("test");
		review.setReviewContent("fun fun life");
		apiService.writeReview(3, review);
		
		apiService.getReviewList(3).forEach(it -> System.out.println(it.toString()));
	}
	
}
