package com.luopc.thead.immutable;

public class PrintPersonThread extends Thread {

	private final Person person;

	private String sayWhat;

	public PrintPersonThread(Person person) {
		this.person = person;
	}

	public PrintPersonThread(final String va) {
		this.person = new Person("ABC", "china");
		this.sayWhat = va;
	}

	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " prints " + person);
		}
	}
}
