package com.board.www.bbs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BbsRecommend {
	private int recommendNo;
	private int bbsId;
	private String userId;
	private boolean postive;
	private boolean negative;
	private boolean isRecommend;
}
