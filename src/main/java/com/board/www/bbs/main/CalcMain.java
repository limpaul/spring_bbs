package com.board.www.bbs.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.board.www.bbs.calc.Calc;
import com.board.www.bbs.calc.CalcConfig;
import com.board.www.bbs.calc.User;

public class CalcMain {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// Calc ca = (Calc)ac.getBean("calc1");
		Calc ca = (Calc) ac.getBean("calc2");
		User user = (User)ac.getBean("user");
		System.out.println(user.toString());
		user.getCalc().add(1, 2);
		/*
		ApplicationContext ac = new AnnotationConfigApplicationContext(CalcConfig.class);
		Calc ca = (Calc) ac.getBean("calc2");
		ca.add(1, 2);
		ca.min(4, 2);
		ca.mul(3, 5);
		ca.div(4, 2);
		*/	
	}
}
