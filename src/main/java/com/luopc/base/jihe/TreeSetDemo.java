package com.luopc.base.jihe;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {

	private String name;

	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age == o.age) {
			return this.name.compareTo(o.name);
		}else {
			return this.age - o.age;
		}
		
	}

	@Override
	public String toString() {

		return "[name=" + name + " ,age=" + age + "]";
	}

}

public class TreeSetDemo {

	public static void main(String[] args) {
		Set<Person> ts = new TreeSet<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			ts.add(new Person("No." + i, random.nextInt(100)));
		}
		System.out.println(ts);
	}

}
