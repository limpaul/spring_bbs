package com.board.www.bbs.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Train {
	public static void main(String[] args) {
		/*
		 * ApplicationContext ac = new
		 * ClassPathXmlApplicationContext("trainapplication.xml"); Train train
		 * =(Train)ac.getBean("train"); train.toString();
		 */
		Object o = 333;
		Object s = "1234";
		int i = (Integer)o;
		System.out.println(i);
		
		String st = (String)s;
		System.out.println(st);
	}
}
