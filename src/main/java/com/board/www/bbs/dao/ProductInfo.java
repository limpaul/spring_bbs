package com.board.www.bbs.dao;

import java.util.ArrayList;

import com.board.www.bbs.dto.Product;

public interface ProductInfo {
	public ArrayList<Product> getProductList();
	//public ArrayList<Product> findByProductName(String productName);
	//public ArrayList<Product> findByProduct_Category_Type(String category, String type);
	//public ArrayList<Product> findByProduct_Category_Type_Brand(String category, String type, String brand);
	//public ArrayList<Product> findByPriceBetween(int lowPrice, int highPrice);
}
