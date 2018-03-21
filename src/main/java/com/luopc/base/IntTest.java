package com.luopc.base;

import org.junit.Test;

public class IntTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 128;
		Integer i2 = 128;
		Integer i3 = new Integer(128);
		// Integer会自动拆箱为int，所以为true
		System.out.println(i == i2);// true
		System.out.println(i == i3);// true
		System.out.println("**************");
		Integer i5 = 127;// java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
		Integer i6 = 127;// java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
		System.out.println(i5 == i6);// true
		/**/
		i5 = 128;
		i6 = 128;
		System.out.println(i5 == i6);// false
		Integer ii5 = new Integer(127);
		System.out.println(i5 == ii5); // false
		System.out.println(i5 == i); // true
		Integer i7 = new Integer(128);
		Integer i8 = new Integer(123);
		System.out.println(i7 == i); // true
		System.out.println(i7 == i2); // false
		System.out.println(i7 == i3); // false
		System.out.println(i7 == i8); // false
	}

	@Test
	public void test001() {
		int a = Integer.parseInt("0", 10); // 返回 0
		int b = Integer.parseInt("473", 10); // 返回 473
		int c = Integer.parseInt("-0", 10); // 返回 0
		int d = Integer.parseInt("-FF", 16); // 返回 -255
		int e = Integer.parseInt("1100110", 2); // 返回 102
		int f = Integer.parseInt("2147483647", 10); // 返回 2147483647
		int g = Integer.parseInt("-2147483648", 10); // 返回 -2147483648
		// int m = Integer.parseInt("2147483648", 10); // 抛出 NumberFormatException
		// int i = Integer.parseInt("99", 8); // 抛出 NumberFormatException
		// int j = Integer.parseInt("Hollis", 10); // 抛出 NumberFormatException
		// int k = Integer.parseInt("Hollis", 27); // 抛出 NumberFormatException
		int o = Integer.parseInt("ADMIN", 27); // 返回 5586836
		System.out.println(a + "\n" + b + "\n" + c + "\n" + o + "\n");
		String gs = Integer.toString(g);

	}

	@Test
	public void test002() {
		int cap = 12;
		int n = cap - 1;
		n |= n >>> 1;
		int a = 16;
		a |= 14;
		System.out.println(12);
		System.out.println(n);
		System.out.println(a);
	}

	@Test
	public void test003() {
		int cap = 34;
		int m = 34;
		System.out.println("cap :" + Integer.toBinaryString(cap));
		int n = cap - 1;// 防止 cap = 2^x次方可以和下面没有减1的方法比较
		System.out.println("n :" + Integer.toBinaryString(n) + " [] m : " + Integer.toBinaryString(m));
		n |= n >>> 1;
		m |= m >>> 1;
		System.out.println("n |= n >>> 1 :" + Integer.toBinaryString(n) + " [] m : " + Integer.toBinaryString(m));//
		n |= n >>> 2;
		m |= m >>> 2;
		System.out.println("n |= n >>> 2 :" + Integer.toBinaryString(n) + " [] m : " + Integer.toBinaryString(m));
		n |= n >>> 4;
		m |= m >>> 4;
		System.out.println("n |= n >>> 4 :" + Integer.toBinaryString(n) + " [] m : " + Integer.toBinaryString(m));
		n |= n >>> 8;
		m |= m >>> 8;
		System.out.println("n |= n >>> 8 :" + Integer.toBinaryString(n) + " [] m : " + Integer.toBinaryString(m));
		n |= n >>> 16;
		m |= m >>> 16;
		System.out.println("n |= n >>> 16 :" + Integer.toBinaryString(n) + " [] m : " + Integer.toBinaryString(m));
		System.out.println(n + 1);
		System.out.println(m + 1);
	}

	@Test
	public void test004() {
		System.out.println("-------------------obj：");
		Object ob1 = new Object();
		Object ob2 = new Object();
		System.out.println(ob1 == ob2);// false
		System.out.println(ob1.equals(ob2));// false
		System.out.println("-------------------Integer = new Integer(456)");
		Integer a1 = new Integer(456);
		Integer a2 = new Integer(456);
		System.out.println(a1 == a2);// false
		System.out.println(a1.equals(a2));// ture
		System.out.println("-------------------Integer = new Integer(127)");
		// int i = 127;
		Integer b1 = new Integer(127);
		Integer b2 = new Integer(127);
		System.out.println(b1 == b2);// false
		System.out.println(b1.equals(b2));// true
		System.out.println("-------------------Integer = 456");
		Integer c1 = 456;
		Integer c2 = 456;
		System.out.println(c1 == c2);// false
		System.out.println(c1 == a1);// false
		System.out.println(c1.equals(c2));// true
		System.out.println("-------------------Integer = 127");
		Integer d1 = 127;
		Integer d2 = 127;
		System.out.println(d1 == d2);// true
		System.out.println(d1 == b1);// false
		System.out.println(d1.equals(d2));// true
		System.out.println("----------------------------");
		int e1 = 456;
		int e2 = 456;
		int f1 = 127;
		int f2 = 127;
		System.out.println("e1==a1:" + (e1 == a1));// true
		System.out.println("e1==c1:" + (e1 == c1));// true
		System.out.println("a1==c1:" + (a1 == c1));// false
		System.out.println("e1==e2:" + (e1 == e2));// true
		System.out.println("f1==b1:" + (f1 == b1));// true
		System.out.println("f1==d1:" + (f1 == d1));// true
		System.out.println("b1==d1:" + (b1 == d1));// false
		System.out.println("f1==f2:" + (f1 == f2));// true
	}

	@Test
	public void test005() {
		int in1 = 127;//int in1 = 127;
		int in2 = new Integer(127);// new Integer(127).intValue();
		int in2s = new Integer(127);// new Integer(127).intValue();
		int in3 = Integer.valueOf(127);// Integer.valueOf(127).intValue();
		int in3s = Integer.valueOf(127);// Integer.valueOf(127).intValue();
		Integer in4 = 127;// Integer.valueOf(127);
		Integer in4s = 127;// Integer.valueOf(127);
		Integer in5 = Integer.valueOf(127);// Integer.valueOf(127);
		Integer in5s = Integer.valueOf(127);// Integer.valueOf(127);
		Integer in6 = new Integer(127);// new Integer(127);
		Integer in6s = new Integer(127);// new Integer(127);
		System.out.println("--------in1--------");
		System.out.println(in1 == in2);// true
		System.out.println(in1 == in3);// true
		System.out.println(in1 == in4);// true
		System.out.println(in1 == in5);// true
		System.out.println(in1 == in6);// true
		System.out.println("--------in2--------");
		System.out.println(in2 == in2s);// true
		System.out.println(in2 == in3);// true
		System.out.println(in2 == in4);// true
		System.out.println(in2 == in5);// true
		System.out.println(in2 == in6);// true
		System.out.println("--------in3--------");
		System.out.println(in3 == in3s);// true
		System.out.println(in3 == in4);// true
		System.out.println(in3 == in5);// true
		System.out.println(in3 == in6);// true
		System.out.println("--------in4--------");
		System.out.println(in4 == in4s);// true
		System.out.println(in4 == in5);// true
		System.out.println(in4 == in6);// false
		System.out.println("--------in5--------");
		System.out.println(in5 == in5s);// true
		System.out.println(in5 == in6);// false
		System.out.println("--------in6--------");
		System.out.println(in6 == in6s);// false
	}

	@Test
	public void test006() {
		int a1 = 456;//int a1 = 456;
		int a2 = new Integer(456);// new Integer(456).intValue();
		int a2s = new Integer(456);// new Integer(456).intValue();
		int a3 = Integer.valueOf(456);// new Integer(456).intValue();
		int a3s = Integer.valueOf(456);// new Integer(456).intValue();
		Integer a4 = 456;// Integer.valueOf(456);
		Integer a4s = 456;// Integer.valueOf(456);
		Integer a5 = Integer.valueOf(456);// Integer.valueOf(456);
		Integer a5s = Integer.valueOf(456);// Integer.valueOf(456);
		Integer a6 = new Integer(456);// Integer.valueOf(456);
		Integer a6s = new Integer(456);// Integer.valueOf(456);
		System.out.println("--------a1--------");
		System.out.println(a1 == a2);// true
		System.out.println(a1 == a3);// true
		System.out.println(a1 == a4);// true
		System.out.println(a1 == a5);// true
		System.out.println(a1 == a6);// true
		System.out.println("--------a2--------");
		System.out.println(a2 == a2s);// true
		System.out.println(a2 == a3);// true
		System.out.println(a2 == a4);// true
		System.out.println(a2 == a5);// true
		System.out.println(a2 == a6);// true
		System.out.println("--------a3--------");
		System.out.println(a3 == a3s);// true
		System.out.println(a3 == a4);// true
		System.out.println(a3 == a5);// true
		System.out.println(a3 == a6);// true
		System.out.println("--------in4--------");
		System.out.println(a4 == a4s);// false
		System.out.println(a4 == a5);// false
		System.out.println(a4 == a6);// false
		System.out.println("--------in5--------");
		System.out.println(a5 == a5s);// false
		System.out.println(a5 == a6);// false
		System.out.println("--------in6--------");
		System.out.println(a6 == a6s);// false

	}

}

enum tesColor {
	RED, BLUE, GREEN;
}