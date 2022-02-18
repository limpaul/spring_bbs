package com.board.www.bbs.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.www.bbs.dao.BoardDao;
import com.board.www.bbs.dao.IDao;
import com.board.www.bbs.dto.Bbs;
import com.board.www.bbs.dto.BbsLikeUnLike;
import com.board.www.bbs.dto.BbsRecommend;
import com.board.www.bbs.dto.BoardList;
import com.board.www.bbs.dto.Review;

@Service
public class ApiService {
	private IDao iDao;
	private BoardDao myBatisBoardDao;
	private SqlSession sqlSession;

	@Autowired
	public ApiService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		iDao = sqlSession.getMapper(IDao.class);
		myBatisBoardDao = sqlSession.getMapper(BoardDao.class);
	}
	public Boolean checkEmailList(String userEmail) {
		String result = iDao.userEmailCheck(userEmail);
		
		if(result == null) {
			return false;
		}
		return true;
	}
	public Boolean checkUserList(String userId) {
		String result = iDao.userIdCheck(userId);
		
		if(result == null) {
			return false;
		}
		return true;
	}
	public BoardList getBoardList(int page) {
		if(page >= 1) {
			page = page + 5;
		}
		BoardList boardList = new BoardList();
		boardList.setBbs(myBatisBoardDao.getList(page));
		boardList.setBbsPage(myBatisBoardDao.getBbsCount(5));
		boardList.getBbs().forEach(bbs -> {
			bbs.setBbsRecommend(countBbsRecommend(bbs.getBbsID()).getPostiveNum());
		});
		return boardList;
	}

	public String removeBbs(Map<String, String> removeBbs) {
		int bbsID = Integer.parseInt(removeBbs.get("bbsID"));
		// 게시판 비밀번호
		String bbsSecret = removeBbs.get("bbsSecret");

		// mybatis로부터 쿼리 가져옴 게시판 번호랑, 아이디 반환 값 호출
		IDao dao = sqlSession.getMapper(IDao.class);
		Map<String, Object> bbs = myBatisBoardDao.findBoardById(bbsID);

		// 해당 게시글이 db에 있는 경우 문자열 반환값 true를 반환 외에 false반환
		if (bbs != null) {
			int bbsrID = (Integer) bbs.get("bbsID");
			String bbsrSecret = (String) bbs.get("bbsSecret");
			if (bbsID == bbsrID && bbsSecret.equals(bbsrSecret)) {
				myBatisBoardDao.deleteBoard(bbsID);
				return "true";
			}
		}
		return "false";
	}

	public List<Review> getReviewList(int bbsId, int page, int count) {
		page = page - 1;
		if(page >= 1) {
			page = page * 5;
		}
		return myBatisBoardDao.findReviewById(bbsId, page, count);
	}

	public Bbs findBoardById(int bbsId) {
		Bbs findBbs = myBatisBoardDao.findById(bbsId); // 게시판을 id로 조회한다..
		int bbsReviewCount = myBatisBoardDao.getBbsReviewCount(bbsId, 5);
		
		List<Review> findReviews = myBatisBoardDao.findReviewById(bbsId, 0, 5); // review 정보를 불러온다
		findBbs.setReviews(findReviews); // 게시판에 review 정보를넣어준다.
		findBbs.setReviewCount(bbsReviewCount); // 리뷰 페이지 갯수 출력
		return findBbs;
	}

	public void writeReview(int bbsId, Review review) {
		review.setBbsId(bbsId); // bbsId 설정.
		myBatisBoardDao.writeReview(review);
	}

	public List<BbsRecommend> findRecommendById(int bbsId, BbsRecommend bbsRecommend) {
		bbsRecommend.setBbsId(bbsId); // 추천에 아이디가 존재하는 확인한다.
		List<BbsRecommend> recommends = myBatisBoardDao.findRecommendByUserId(bbsRecommend.getBbsId());
		System.out.println(">> rmd: "+recommends);
		return recommends;
	}


	
	public int getBbsReviewCount(int bbsId, int count) { // 총 리뷰페이지가 몇개인가?
		 // 기본적으로 5개 기준으로 reviewPage를 몇개 가져올것인지 
		return myBatisBoardDao.getBbsReviewCount(bbsId, count);
	}
//	private void likeOrunLike(BbsRecommend bbsRecommend) {
//		if(bbsRecommend.getPostive() == 1) {
//			iDao.plusRecommend();
//		}else if(bbsRecommend.getNegative() == 1) {
//			iDao.minusRecommend();
//		}
//	}

	public int getBbsCount(int count) {
		return myBatisBoardDao.getBbsCount(count);
	}
	/* 추천 기능  */
	public Boolean recommend(int bbsId, BbsRecommend bbsRecommend) {
		bbsRecommend.setBbsId(bbsId);
		Boolean result = myBatisBoardDao.isRecommendable(bbsRecommend);
		if(result == null || result == true) {
			return myBatisBoardDao.addRecommend(bbsRecommend);
		}
		if(result == false) {
			return false;
		}
		return false;
	}
	/* 해당 게시글 추천 개수 */
	public BbsLikeUnLike countBbsRecommend(int bbsId) {
		int postive = myBatisBoardDao.findBbsRecommendNumById(bbsId, true);
		int negative = myBatisBoardDao.findBbsRecommendNumById(bbsId, false);
		BbsLikeUnLike bbsLikeUnLike = new BbsLikeUnLike();
		bbsLikeUnLike.setBbsId(bbsId);
		bbsLikeUnLike.setPostiveNum(postive);
		bbsLikeUnLike.setNegativeNum(negative);
		
		return bbsLikeUnLike;
	}
	
}
