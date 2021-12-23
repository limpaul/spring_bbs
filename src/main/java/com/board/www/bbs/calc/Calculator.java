package com.board.www.bbs.calc;


public class Calculator implements Calc{
	
	
	public int add(int x, int y) {
		int result = x + y;
		System.out.println(x+" + "+y+ " = "+result);
		return result;
	}

	public int min(int x, int y) {
		int result = x - y;
		System.out.println(x+" - "+y+ " = "+result);
		return result;
	}

	public int mul(int x, int y) {
		int result = x * y;
		System.out.println(x+" * "+y+ " = "+result);
		return result;
	}

	public int div(int x, int y) {
		int result = x / y;
		System.out.println(x+" / "+y+ " = "+result);
		return result;
	}

}
