package com.luopc.thead.immutable;

public class PrintPersonThreadTest {

	public static void main(String[] args) {
		Person alice = new Person("Alice","Alaska");
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}

}
