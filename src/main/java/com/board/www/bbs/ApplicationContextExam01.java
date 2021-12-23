package com.board.www.bbs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserBean ub = (UserBean)ac.getBean("userBean", UserBean.class);
		ub.setName("test");
		System.out.println("getName(): "+ub.getName());
	}
}
