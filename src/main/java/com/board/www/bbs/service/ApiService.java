package com.board.www.bbs.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.www.bbs.dao.IDao;
import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.dto.Review;

@Service
public class ApiService {
	private IDao iDao;
	private SqlSession sqlSession;

	@Autowired
	public ApiService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		iDao = sqlSession.getMapper(IDao.class);
	}

	public List<Bbs> getBoardList() {
		return iDao.getList();
	}

	public String removeBbs(Map<String, String> removeBbs) {
		int bbsID = Integer.parseInt(removeBbs.get("bbsID"));
		// 게시판 비밀번호
		String bbsSecret = removeBbs.get("bbsSecret");

		// mybatis로부터 쿼리 가져옴 게시판 번호랑, 아이디 반환 값 호출
		IDao dao = sqlSession.getMapper(IDao.class);
		Map<String, Object> bbs = dao.findBoardById(bbsID);

		// 해당 게시글이 db에 있는 경우 문자열 반환값 true를 반환 외에 false반환
		if (bbs != null) {
			int bbsrID = (Integer) bbs.get("bbsID");
			String bbsrSecret = (String) bbs.get("bbsSecret");
			if (bbsID == bbsrID && bbsSecret.equals(bbsrSecret)) {
				dao.deleteBoard(bbsID);
				return "true";
			}
		}
		return "false";
	}

	public List<Review> getReviewList(int bbsId) {
		return iDao.findReviewById(bbsId);
	}

	public Bbs findBoardById(int bbsId) {
		// TODO Auto-generated method stub
		return iDao.findById(bbsId);
	}

	public void writeReview(int bbsId, Review review) {
		review.setBbsId(bbsId); // bbsId 설정.
		iDao.writeReview(review);
	}
	
}
