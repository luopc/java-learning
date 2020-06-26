package com.luopc.thead;

import java.util.LinkedList;

public class TestMain {

	static {
//		System.out.println("1111111111111");
	}
	
	static public  void main(String[] args) {
//		System.out.println("12032");
		LinkedList<String> test = new LinkedList<>();
		test.add("20200626");
		test.add("20200627");
		System.out.println(test.size());
		test.removeFirst();
		System.out.println(test.size());

	}
	
	
}
