package com.luopc.base.collect;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Book {

	private String name;

	private int num;

	public Book(String name, int num) {
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return "[name=" + name + " ,num=" + num + "]";
	}

}

public class TreeSetDemo2 {

	public static void main(String[] args) {
		Set<Book> ts = new TreeSet<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			ts.add(new Book("No." + i, random.nextInt(100)));
		}
		System.out.println(ts);
	}

}
