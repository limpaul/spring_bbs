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
		Bbs findBbs = iDao.findById(bbsId); // 게시판을 id로 조회한다..
		List<Review> findReviews = iDao.findReviewById(bbsId); // review 정보를 불러온다 
		findBbs.setReviews(findReviews); // 게시판에 review 정보를넣어준다.
		
		return findBbs;
	}

	public void writeReview(int bbsId, Review review) {
		review.setBbsId(bbsId); // bbsId 설정.
		iDao.writeReview(review);
	}

	/*
	 * public String recommed(int bbsId, Map<String, Object> map) { // TODO: 추천 기능
	 * 이미 했거나 추후 작성 String userId = (String)map.get("userId"); // 추천자를 가져온다. // 이미
	 * 추천을 했으면? boolean isOk = iDao.verifyRecommend(bbsId, userId); // 어느 게시판 추천자인지
	 * 확인
	 * 
	 * //추천을 했거나 아니거나 if(isOk) { // 추천을 하지 않았으면 긍정 또는 부정. String choice =
	 * (String)map.get("choice"); int like_unlike = postiveOrnegative(choice);
	 * if(like_unlike == 1) { iDao.bbsLike(bbsId, like_unlike); }else {
	 * iDao.bbsUnLike(bbsId, like_unlike); } return "{}"; }else { return
	 * "이미 추천을 하셨습니다."; } }
	 */
	private int postiveOrnegative(String value) {
		if(value == "true") {
			return 1;
		}else {
			return -1;
		}
	}
	
}
