package com.board.www.bbs.dto;

import java.util.List;

public class BoardList {
	private List<Bbs> bbs;
	private int bbsPage;
	
	
	public List<Bbs> getBbs() {
		return bbs;
	}
	public void setBbs(List<Bbs> bbs) {
		this.bbs = bbs;
	}
	public int getBbsPage() {
		return bbsPage;
	}
	public void setBbsPage(int bbsPage) {
		this.bbsPage = bbsPage;
	}
	@Override
	public String toString() {
		return "BoardList [bbs=" + bbs + ", bbsPage=" + bbsPage + "]";
	}
	
}
