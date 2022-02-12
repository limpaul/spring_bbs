package com.board.www.bbs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Bbs {
	private int bbsID;
	private String bbsTitle;
	private String userID;
	private String bbsDate;
	private String bbsContent;
	@JsonIgnore
	private String bbsSecret;
	private int bbsAvailable;
	private int bbsRecommend;
	private int bbsVisited;
	private List<Review> reviews;
	private int reviewPage = 1;
	
	public Bbs() {
		
	}
	public Bbs(int bbsID, String bbsTitle, String userID, 
			String bbsDate, String bbsContent, String bbsSecret, 
			int bbsRecommend, int bbsVisited) {
		
		this.bbsID = bbsID;
		this.bbsTitle = bbsTitle;
		this.userID = userID;
		this.bbsDate = bbsDate;
		this.bbsContent = bbsContent;
		this.bbsSecret = bbsSecret;
		this.bbsRecommend = bbsRecommend;
		this.bbsVisited = bbsVisited;
	}
	public Bbs(int bbsID, String bbsTitle, String userID,
			String bbsDate, String bbsContent,
			int bbsRecommend, int bbsVisited) {
		
		this.bbsID = bbsID;
		this.bbsTitle = bbsTitle;
		this.userID = userID;
		this.bbsDate = bbsDate;
		this.bbsContent = bbsContent;
		this.bbsRecommend = bbsRecommend;
		this.bbsVisited = bbsVisited;
	}
	
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	
	public String getBbsSecret() {
		return bbsSecret;
	}
	public void setBbsSecret(String bbsSecret) {
		this.bbsSecret = bbsSecret;
	}
	public int getBbsAvailable() {
		return bbsAvailable;
	}
	public void setBbsAvailable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}
	public int getBbsRecommend() {
		return bbsRecommend;
	}
	public void setBbsRecommend(int bbsRecommend) {
		this.bbsRecommend = bbsRecommend;
	}
	public int getBbsVisited() {
		return bbsVisited;
	}
	public void setBbsVisited(int bbsVisited) {
		this.bbsVisited = bbsVisited;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	public int getReviewCount() {
		return reviewPage;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewPage = reviewCount;
	}
	@Override
	public String toString() {
		return "Bbs [bbsID=" + bbsID + ", bbsTitle=" + bbsTitle + ", userID=" + userID + ", bbsDate=" + bbsDate
				+ ", bbsContent=" + bbsContent + ", bbsSecret=" + bbsSecret + ", bbsAvailable=" + bbsAvailable
				+ ", bbsRecommend=" + bbsRecommend + ", bbsVisited=" + bbsVisited + ", reviews=" + reviews
				+ ", reviewPage=" + reviewPage + "]";
	}

}
