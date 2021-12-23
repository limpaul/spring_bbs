package com.board.www.bbs.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.www.bbs.dao.UserDao;
import com.board.www.bbs.dto.User;
import com.board.www.bbs.service.BbsService;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	BbsService service;
	@Mock
	UserRepository repository;
	@Mock
	UserDao userDao;
	@Test
	public void login_테스트() {
		User user = new User();
		user.setUserID("test");
		user.setUserPassword("1234");
		given(userDao.login(any(), any())).willReturn(1);
		given(repository.loginAction(any(), any())).willReturn(1);
		assertEquals(1, userDao.login(any(), any()));
		assertEquals(1, repository.loginAction(any(), any()));
	}
}
