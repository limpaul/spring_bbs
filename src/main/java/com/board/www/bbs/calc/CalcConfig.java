package com.board.www.bbs.calc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalcConfig {
	@Bean
	public Calc calc(){
		return new Calculator();
	}
	/*
	 <bean id="calc" class="com.board.www.bbs.calc.Caculator">
	 */
	@Bean
	public Calc calc2(){
		return new Calculator2();
	}
	/*
	 <bean id="calc" class="com.board.www.bbs.calc.Caculator2">
	 */
}
