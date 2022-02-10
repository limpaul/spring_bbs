package com.board.www.bbs.dto;

public class Review {
	private int reviewId;
	private int bbsId;
	private String userId;
	private	String reviewContent;
	private String reviewDate;
	private int reviewRecommend;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	public int getReviewRecommend() {
		return reviewRecommend;
	}
	public void setReviewRecommend(int reviewRecommend) {
		this.reviewRecommend = reviewRecommend;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", bbsId=" + bbsId + ", userId=" + userId + ", reviewContent="
				+ reviewContent + ", reviewDate=" + reviewDate + ", reviewRecommend=" + reviewRecommend + "]";
	}
	
}
