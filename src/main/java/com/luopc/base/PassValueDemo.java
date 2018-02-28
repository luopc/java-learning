package com.luopc.base;

import org.junit.Test;

public class PassValueDemo {

	@Test
	public void test001() {
		int x = 5;
		passValue(x);
		System.out.println(x);
	}

	private void passValue(int x) {
		x = 3;
	}

	@Test
	public void test002() {
		ObjValue ov = new ObjValue();
		ov.x = 5;
		passValue(ov);
		System.out.println(ov.x);
	}

	private void passValue(ObjValue o) {
		o.x = 3;
	}

}

class ObjValue {
	public int x;
	public String y;
}

class Person {
	int age;
	String name;

	public Person() {

	}

	public Person(int age) {
		this.age = age;
	}

	public Person(int age, String name) {
		this(age);
		this.name = name;
	}

}