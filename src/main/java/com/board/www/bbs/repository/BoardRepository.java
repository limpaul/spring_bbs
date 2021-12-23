package com.board.www.bbs.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.www.bbs.dao.BbsDao;
import com.board.www.bbs.dao.IDao;
import com.board.www.bbs.dto.Bbs;

@Repository
public class BoardRepository {
	//private BbsDao bbsDao;
	private IDao iDao;
	private SqlSession sqlSession;
	public BoardRepository() {

	}
	@Autowired
	public BoardRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		iDao = this.sqlSession.getMapper(IDao.class);
	}
	
	
	public List<Bbs> freeListPage() {
		//return bbsDao.getList();
		return iDao.getList();
	}
	public int bbsWrite(Bbs bbs) {
		//return bbsDao.write(bbs);
		return iDao.write(bbs);
	}
	public Bbs findById(int bbsID){
		Bbs bbs = iDao.findById(bbsID);
		return bbs;
	}
//	public int bbsUpdate(int bbsID){
//		int result = bbsDao.bbsUpdate(bbsID);
//		return result;
//	}
}
