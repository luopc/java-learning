package com.luopc.reflex;

import java.lang.reflect.Constructor;
import java.util.Date;

class Person {

	private String name;
	private int age;

	public Person() {
	}

	public Person(String name) {

	}

	public Person(String name, int age) {

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
	
	
}

public class ReflexDemo {

	public static void main(String[] args) {
		Class<?> cls = Person.class;
		Constructor<?>[] conts = cls.getConstructors();
		for (int i = 0; i < conts.length; i++) {
			Constructor ct = conts[i];
			// System.out.println(ct);
			System.out.println(ct.getName());
		}

	}

}
