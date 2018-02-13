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
		System.out.println(i == i2);
		System.out.println(i == i3);
		System.out.println("**************");
		Integer i5 = 127;// java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
		Integer i6 = 127;
		System.out.println(i5 == i6);
		// true
		/**/
		// i5 = 128;
		i6 = 128;
		System.out.println(i5 == i6);// false
		Integer ii5 = new Integer(127);
		System.out.println(i5 == ii5); // false
		Integer i7 = new Integer(128);
		Integer i8 = new Integer(123);
		System.out.println(i7 == i); // false
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

}

enum tesColor {
	RED, BLUE, GREEN;
}