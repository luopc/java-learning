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
		//kawd-829  KAWD-814 SSNI-229 SSNI-645 SSNI-647 SSNI-733 SSNI-780 IPX-459 kawd-829
	}
	
	
}
