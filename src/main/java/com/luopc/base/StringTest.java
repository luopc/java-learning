package com.luopc.base;

public class StringTest {

	public static void main(String[] args) {
		StringBuffer bf = new StringBuffer("13785428001");
		bf.replace(3, 7, "****");
		System.out.println(bf);
		
		StringBuilder bd = new StringBuilder("13785428001");
		bd.replace(3, 7, "****");
		System.out.println(bf);
	}

}
