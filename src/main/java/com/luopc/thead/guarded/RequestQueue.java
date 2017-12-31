package com.luopc.thead.guarded;

import java.util.Iterator;
import java.util.LinkedList;

public class RequestQueue {

	private final LinkedList<Request> queue = new LinkedList<Request>();

	public synchronized Request getQueue() {
		// System.out.println("begin queue.size() :" + getSize());
		while (queue.size() <= 0) {
			try {
				wait();
				// System.out.println("to run queue.size() :" + getSize());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Request> it = queue.iterator();
		Request qu = it.next();
		it.remove();
		// System.out.println("to remove queue.size() :" + getSize());
		// showly();
		return qu;
	}

	public synchronized void remove() {
		while (queue.size() <= 0) {
			try {
				wait();
				// System.out.println("to run queue.size() :" + getSize());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Request> it = queue.iterator();
		it.next();
		it.remove();
		// showly();
	}

	public synchronized void putQueue(Request e) {
		queue.addLast(e);
		// System.out.println("begin notify queue.size() :" + getSize());
		// showly();
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ":" + queue);
	}

	private void showly() {
		System.out.print(Thread.currentThread().getName() + ":");
		for (Request request : queue) {
			System.out.print(request + ",");
		}
		System.out.print("\n");
	}

	private synchronized int getSize() {
		return queue.size();
	}

}
