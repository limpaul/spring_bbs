package com.board.www.bbs.dao;

import org.apache.ibatis.annotations.Param;

public interface BoardDao {
	int getBbsReviewCount(@Param("bbs_id")int bbsId ,@Param("count") int count);

	int getBbsCount(int count);
}
