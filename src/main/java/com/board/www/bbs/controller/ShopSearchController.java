package com.board.www.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopSearchController {
	@GetMapping("/shopmain")
	public String shopMain() {
		return "shopmain";
	}
}
