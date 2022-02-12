package com.board.www.bbs.dto;

public class BbsRecommend {
	private int recommendNo;
	private int bbsId;
	private String userId;
	private int postive;
	private int negative;
	
	
	public int getRecommendNo() {
		return recommendNo;
	}
	public void setRecommendNo(int recommendNo) {
		this.recommendNo = recommendNo;
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
	public int getPostive() {
		return postive;
	}
	public void setPostive(int postive) {
		this.postive = postive;
	}
	public int getNegative() {
		return negative;
	}
	public void setNegative(int negative) {
		this.negative = negative;
	}
	@Override
	public String toString() {
		return "BbsRecommend [recommendNo=" + recommendNo + ", bbsId=" + bbsId + ", userId=" + userId + ", postive="
				+ postive + ", negative=" + negative + "]";
	}
	
	
}
