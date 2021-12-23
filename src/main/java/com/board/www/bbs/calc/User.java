package com.board.www.bbs.calc;

public class User {
	private String name;
	private int age;
	private char sex;
	private Calc calc;
	public User(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public Calc getCalc() {
		return calc;
	}
	public void setCalc(Calc calc) {
		this.calc = calc;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}
