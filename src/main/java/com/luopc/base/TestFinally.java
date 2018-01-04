package com.luopc.base;

public class TestFinally {

	public static int testF1() {
		int i = 0;
		try {
			i = 2;
			return i;
		} catch (Exception e) {
			i = 3;
			return i;
		} finally {
			i = 4;
			System.out.println("1 has run");
		}
	}

	public static String testF2() {
		StringBuffer i = new StringBuffer("Hello ");
		try {
			return i.toString();
		} catch (Exception e) {
			return null;
		} finally {
			i.append("word");
			System.out.println("2 has run");
		}
	}
	
	public static StringBuffer testF3() {
		StringBuffer i = new StringBuffer("Hello ");
		try {
			return i;
		} catch (Exception e) {
			return null;
		} finally {
			i.append("word");
			System.out.println("2 has run");
		}
	}

	public static void main(String[] args) {
		int res = TestFinally.testF1();
		System.out.println(res);
		String res2 = TestFinally.testF2();
		System.out.println(res2);
		StringBuffer res3 = TestFinally.testF3();
		System.out.println(res3);
		

	}

}
