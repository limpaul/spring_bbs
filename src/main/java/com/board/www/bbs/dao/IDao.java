package com.board.www.bbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.dto.BbsRecommend;
import com.board.www.bbs.dto.Review;
import com.board.www.bbs.dto.User;

public interface IDao {
	public List<Bbs> getList(int count);
	public int write(Bbs bbs);
	public Bbs findById(int bbsID);
	public void deleteBoard(int bbsID);
	public Map<String, Object> findBoardById(int bbsID);
	public List<Review> findReviewById(@Param("bbsId") int bbsId, @Param("page") int page, @Param("count") int count);
	public String login(String userID);
	public int join(User user);
	public void writeReview(Review review);
	public List<BbsRecommend> findRecommendByUserId(int bbsId);
	public int addRecommend(BbsRecommend rmd);
	
}