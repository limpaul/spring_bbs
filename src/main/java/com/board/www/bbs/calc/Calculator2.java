package com.board.www.bbs.calc;

public class Calculator2 implements Calc{
	public int add(int x, int y) {
		int result = x + y;
		System.out.println(x+" 더하기 "+y+ " 는 "+result);
		return result;
	}

	public int min(int x, int y) {
		int result = x - y;
		System.out.println(x+" 빼기 "+y+ " 는 "+result);
		return result;
	}

	public int mul(int x, int y) {
		int result = x * y;
		System.out.println(x+" 곱하기	 "+y+ " 는 "+result);
		return result;
	}

	public int div(int x, int y) {
		int result = x / y;
		System.out.println(x+" 나누기 "+y+ " 는 "+result);
		return result;
	}

}
