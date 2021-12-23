package com.board.www.bbs.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.www.bbs.dao.ProductInfo;
import com.board.www.bbs.dto.Product;

@CrossOrigin
@RestController
@RequestMapping("/api/shop/")
public class ShopController {
	private ProductInfo productInfo;
	private SqlSession sqlSession;
	
	public ShopController() {
		
	}
	@Autowired
	public ShopController(SqlSession sqlSession){
		this.sqlSession = sqlSession;
		productInfo = this.sqlSession.getMapper(ProductInfo.class);
	}
	@GetMapping("/list")
	public ArrayList<Product> productList(){
		ArrayList<Product> productList = productInfo.getProductList();
		return productList;
	}
}
