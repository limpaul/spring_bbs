package com.board.www.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.www.bbs.dao.BbsDao;
import com.board.www.bbs.dao.UserDao;

@Configuration
public class AppConfig {
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
	@Bean
	public BbsDao bbsDao() {
		return new BbsDao();
	}
}
