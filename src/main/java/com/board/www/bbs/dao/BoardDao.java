package com.board.www.bbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.dto.BbsRecommend;
import com.board.www.bbs.dto.Review;

public interface BoardDao {
	int getBbsReviewCount(@Param("bbs_id")int bbsId ,@Param("count") int count);
	int getBbsCount(int count);
	
	public void writeReview(Review review);
	public List<BbsRecommend> findRecommendByUserId(int bbsId);
	public Boolean addRecommend(BbsRecommend bbsRecommend);
	
	public List<Bbs> getList(int count);
	public int write(Bbs bbs);
	public Bbs findById(int bbsID);
	public void deleteBoard(int bbsID);
	public Map<String, Object> findBoardById(int bbsID);
	public List<Review> findReviewById(@Param("bbsId") int bbsId, @Param("page") int page, @Param("count") int count);
	Boolean isRecommendable(BbsRecommend bbsRecommend);
	int findBbsRecommendNumById(@Param("bbsId") int bbsId,@Param("type") boolean type);
}
