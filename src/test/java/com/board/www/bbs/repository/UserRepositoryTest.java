package com.board.www.bbs.repository;

import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.www.bbs.dao.UserDao;
import com.board.www.bbs.dto.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.board.www.bbs.config.AppConfig.class)
public class UserRepositoryTest {
	@Autowired
	UserDao userDao;

	@Test
	public void 로그인테스트() { 
		int reuslt = userDao.login("test", "1234");
		Assert.assertEquals(1, reuslt);
	}
	@Test
	public void 회원가입테스트() {
		// id 
		User user = new User("ccc", "1234", "namebb", "m", "bb@korea.ac.r");
		int result = userDao.join(user);
		Assert.assertEquals(1, result);
	}
	
}
