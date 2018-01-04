package com.luopc.thead.produce;

public class Table {

	private final String[] buffer;

	private int tail;
	private int head;

	private int count;

	public Table(int count) {
		this.buffer = new String[count];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
	}

	public synchronized void put(String cake) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " put:" + cake);
		while (count >= buffer.length) {
			wait();
		}
		buffer[tail] = cake;
		tail = (tail + 1) % buffer.length;
		count++;
		notifyAll();
	}

	public synchronized String get() throws InterruptedException {
		while (count <= 0) {
			wait();
		}
		String cake = buffer[tail];
		head = (head + 1) % buffer.length;
		count--;
		notifyAll();
		System.err.println(Thread.currentThread().getName() + " get:" + cake);
		return cake;
	}

}
