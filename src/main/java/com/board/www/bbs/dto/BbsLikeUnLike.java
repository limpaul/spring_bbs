package com.board.www.bbs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BbsLikeUnLike {
	private int bbsId;
	private int postiveNum;
	private int negativeNum;
}
