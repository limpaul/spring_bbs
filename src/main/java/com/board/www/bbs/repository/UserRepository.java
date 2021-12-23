package com.board.www.bbs.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.www.bbs.dao.IDao;
import com.board.www.bbs.dao.UserDao;
import com.board.www.bbs.dto.User;

@Repository
public class UserRepository {
	private IDao dao;
	private SqlSession sqlSession;
	public UserRepository() {

	}
	@Autowired
	public UserRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		dao = this.sqlSession.getMapper(IDao.class);
	}
	
	
	public void joinAction(User user) {
		dao.join(user);
	}
	public int loginAction(String userID, String userPassword) {
		String pwd = dao.login(userID);
		if(pwd == null) return -1;		
		if(pwd.equals(userPassword))return 1;
		else return 0;
	}
}
