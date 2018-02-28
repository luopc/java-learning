package com.luopc.base;

import org.junit.Test;

class StaticCount {

	private static int count = 0;
	// 每次调用任意构造方法实例化都会执行
	{
		count++;
	}

	// 提供方法返回实例化过的次数
	public static int getCount() {
		return count;
	}

}

public class StaticCountDemo {

	public static void main(String[] args) {
		new StaticCount();
		new StaticCount();

		System.out.println(new StaticCount().getCount());
		for (String str : args) {
			System.out.println(str);
		}
	}

	@Test
	public void test001() {
		String args[] = {};
		args = new String[10];
		args = new String[] { "11" };
		new StaticCountDemo().main(args);
		new StaticCountDemo().main(new String[10]);
		StaticCountDemo.main(new String[]{ "22" });
	}
}