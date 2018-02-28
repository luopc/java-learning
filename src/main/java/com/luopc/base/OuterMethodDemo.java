package com.luopc.base;

public class OuterMethodDemo {

	public static void main(String[] args) {
		OuterTest_1 o1 = new OuterTest_1();
		o1.test();
	}

}

class OuterTest_1 {
	private int outer_i = 100;

	void test() {
		for (int i = 0; i < 5; i++) {
			class Inner {
				void display() {
					System.out.println("display: outer_i " + outer_i);
				}
			}
			Inner inner = new Inner();
			inner.display();
		}
	}
}
