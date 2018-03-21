package com.luopc.base;

import org.junit.Test;

public class StringTest {

	public static void main(String[] args) {
		StringBuffer bf = new StringBuffer("13785428001");
		bf.replace(3, 7, "****");
		System.out.println(bf);

		StringBuilder bd = new StringBuilder("13785428001");
		bd.replace(3, 7, "****");
		System.out.println(bf);

		String str = "13785428001";
		String nstr = str.replace(str.substring(3, 7), "****");
		System.out.println(nstr);
	}

	@Test
	public void testString001() {
		String s = new String();
		s.length();
		String s1 = new String("hello");
		char[] c = { 'h', 'e', 'l', 'l', 'o' };
		String s2 = new String(c);
		String s3 = new String(c, 1, 3);
	}

	@Test
	public void test002() {

		String s = "hello world";
		String s1 = new String("hello world");
		String s2 = new String("hello world");
		String s3 = new String("hello");
		String s4 = "hello world";

		System.out.println(s.equals(s1));
		;
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println("------------------");
		System.out.println(s == s1);
		System.out.println(s1 == s2);
		System.out.println(s == s3);
		System.out.println(s == s4);
	}

	@Test
	public void test003() {
		String s = "helloworld";
		String[] s2 = s.split("abc");
		for (int i = 0; i < s2.length; i++) {
			System.out.println(s2[i] + " " + i);
		}
	}

	@Test
	public void test004() {
		String str = "abc";
		char data[] = { 'a', 'b', 'c' };
		String str2 = new String(data);
		String str3 = new String(data).intern();

		System.out.println(str == str2);
		System.out.println(str == str3);

		String $S = "";

		int mi = 'a' + 'b';
		System.out.println(mi);
		char mc = (char) mi;
		System.out.println(mc);

		byte a = 3;
		short b = a;
		int c = a;
		float d = c;
		double e = d;
		float f = (float) e;
		int g = (int) f;
		short h = (short) g;
		byte m = (byte) h;

	}

	@Test
	public void test005() {
		int x = 3510;
		x = x / 1000 * 1000;
		System.out.println(x);

		int y = -3510;
		y = y / 1000 * 1000;
		System.out.println(y);

		int a = 5;
		int b = 2;
		a += b;
		System.out.println(a);
		a = 5;
		a -= b;
		System.out.println(a);
		a = 5;
		a *= b;
		System.out.println(a);
		a = 5;
		a /= b;
		System.out.println(a);
		a = 5;
		a %= b;
		System.out.println(a);

		// instanceof
		int m = 2;
		m <<= 2;
		System.out.println(2 << 2);
		System.out.println(m);

	}

	@Test
	public void test006() {
		int ch = "你好吗".codePointAt(1);
		System.out.println(ch);
		System.out.println((int) "好".charAt(0));
		
		System.out.println("你好吗".codePointBefore(1));
	}

}
