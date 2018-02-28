package com.luopc.base;

import org.junit.Test;

public class SwitchDemo {

	@Test
	public void test001() {
		Enumtest t = Enumtest.one;

		switch (t) {
		case one:
			System.out.println(Enumtest.one);
			break;
		case two:
			System.out.println(Enumtest.two);
			break;
		case three:
			System.out.println(Enumtest.three);
			break;
		case four:
			System.out.println(Enumtest.four);
			break;
		default:
			break;
		}
	}

	@Test
	public void test002() {
		String str = "C";
		switch (str) {
		case "A":
			System.out.println("A");
			break;
		case "B":
			System.out.println("B");
			break;
		case "C":
			System.out.println("C");
			break;
		default:
			System.out.println(0);
		}
	}

	@Test
	public void test003() {
		// 巧用break,输出2015年指定月份的最大天数
		int year = 2015;
		int month = 8;
		int day = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 2:
			day = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		}

		System.out.println(year + "-" + month + "-" + day);
		System.out.printf("%d-%d-%d", year, month, day);
	}
}

enum Enumtest {
	one, two, three, four, fine
}