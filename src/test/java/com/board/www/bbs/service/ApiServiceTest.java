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

import com.board.www.bbs.dto.BbsLikeUnLike;
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
	public void userEmailCheckTest() {
		String userEmail = "test@bavcer";
		Boolean result = apiService.checkEmailList(userEmail);
		Assert.assertEquals(true, result);
	}
	@Test
	public void userIdCheckTest() {
		String userId = "test";
		Boolean result = apiService.checkUserList(userId);
		Assert.assertEquals(true, result);
	}
	@Test
	public void getList() {
		System.out.println(apiService.getBoardList(0).toString());;
	}
	@Test
	public void getReviewList() {
		//getReviewList("게시판번호", "리뷰 시작페이지", "리뷰 데이터 개수")
		apiService.getReviewList(1, 1, 10).forEach(it -> System.out.println(it.toString()));
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
	@Test
	public void isRecommend() { // 좋아요 싫어요 눌렀을 때 db가 동작을 하는가?
		BbsRecommend bbsRecommend = new BbsRecommend();
		bbsRecommend.setUserId("test");
		System.out.println(apiService.recommend(1, bbsRecommend));
	}
	@Test
	public void addRecommend() { // 좋아요 싫어요 눌렀을 때 db가 동작을 하는가?
		BbsRecommend bbsRecommend = new BbsRecommend();
		bbsRecommend.setUserId("toto");
		bbsRecommend.setNegative(true);
		System.out.println(apiService.recommend(1, bbsRecommend));
	}
	@Test
	public void recommendCount() {
		BbsLikeUnLike bbsLikeUnLike = apiService.countBbsRecommend(1);
		System.out.println(bbsLikeUnLike);
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
	@Test
	public void test() {
		Boolean result = null;
		if(result == null || result == false) {
			System.out.println("here is");
		}
	}
}
