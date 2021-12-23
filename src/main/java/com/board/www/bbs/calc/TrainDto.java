package com.board.www.bbs.calc;

import java.util.List;

public class TrainDto {
	private String name;
	private List<String> ticket;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTicket() {
		return ticket;
	}
	public void setTicket(List<String> ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "TrainDto [name=" + name + ", ticket=" + ticket + "]";
	}
	
}
