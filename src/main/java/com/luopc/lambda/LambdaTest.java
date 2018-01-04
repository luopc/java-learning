package com.luopc.lambda;

import org.junit.Test;

public class LambdaTest {

	@Test
	public void test001() {
		IMessage msg = new IMessage() {
			@Override
			public void print() {
				System.out.println("I send Message!");
			}
		};
		msg.print();
	}

	@Test
	public void test002() {
		IMessage msg = () -> System.out.println("I send Message!");
		msg.print();
	}

	@Test
	public void test003() {
		IMessage2 msg = (String m) -> System.out.println("I send Message:" + m);
		msg.print("hello word!");
	}

	@Test
	public void test004() {
		IMessage2 msg = (String m) -> {
			System.out.println("I send Message:" + m);
		};
		msg.print("hello word!");
	}

	@Test
	public void test005() {
		IMessage3 msg = (p1, p2) -> p1 + p2;
		msg.print(10, 20);

		IMessage3 msg2 = (p1, p2) -> {
			int rs = p1 + p2;
			return rs;
		};
		System.out.println(msg.print(10, 20));
		System.out.println(msg2.print(10, 20));
	}

}

interface IMessage {
	public void print();
}

interface IMessage2 {
	public void print(String msg);
}

interface IMessage3 {
	public int print(int x, int y);
}