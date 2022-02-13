package com.board.www.bbs.dao;

import org.apache.ibatis.annotations.Param;

import com.board.www.bbs.dto.User;

public interface IDao {
	public String login(String userID);
	public int join(User user);
	public String userIdCheck(@Param("userId") String userId);
	public String userEmailCheck(@Param("userEmail") String userEmail);
}