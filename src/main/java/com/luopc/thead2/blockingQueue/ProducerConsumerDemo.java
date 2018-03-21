package com.luopc.thead2.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {

	public static void main(String[] args) throws InterruptedException {
		int qLimit = 10;
		BlockingQueue<String> q = new LinkedBlockingQueue<>(qLimit);
		Thread productThread1 = new Thread(new ProducerThread(q));
		Thread productThread2 = new Thread(new ProducerThread(q));
		Thread consumerThread = new Thread(new ConsumerThread(q));
		productThread1.start();
		productThread2.start();
		consumerThread.start();

		productThread1.join();
		productThread2.join();
		consumerThread.join();
		System.out.println("end");
	}

}

class ProducerThread implements Runnable {

	private BlockingQueue<String> q = null;

	public ProducerThread(BlockingQueue<String> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Produced: No." + i);
				q.put("No." + i);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}

}

class ConsumerThread implements Runnable {

	private BlockingQueue<String> q = null;

	public ConsumerThread(BlockingQueue<String> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Consumed: " + q.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}