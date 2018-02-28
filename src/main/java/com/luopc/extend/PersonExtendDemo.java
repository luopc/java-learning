package com.luopc.extend;

class Person {
	
	{
		System.out.println("person null");
	}

	static {
		System.out.println("person static init");
	}
	
	public Person() {
		System.out.println("person init");
	}

}

class Student extends Person {
	{
		System.out.println("student null");
	}
	static {
		System.out.println("student static init");
	}
	public Student() {
		System.out.println("student init");
	}
}

public class PersonExtendDemo {
	public static void main(String[] args) {
		new Student();
	}
}