package com.luopc.thead.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GateThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		Gate gate = new Gate();
		ExecutorService es = Executors.newFixedThreadPool(4);
		Thread t1 = new Thread(() -> {
			String value = Thread.currentThread().getName();
			String[] values = value.split(",");
			System.out.println(values[0] + ":begin->");
			for (int i = 0; i < 3; i++) {
				gate.pass(values[0], values[1]);
//				Thread.yield();
			}
		}, "zhangsan,ZS");
		t1.start();
		Thread t2 = new Thread(() -> {
			String value = Thread.currentThread().getName();
			String[] values = value.split(",");
			System.out.println(values[0] + ":begin->");
			for (int i = 0; i < 3; i++) {
				gate.pass(values[0], values[1]);
//				Thread.yield();
			}
		}, "Bobby,Brazil");
		t2.start();
		Thread t3 = new Thread(() -> {
			String value = Thread.currentThread().getName();
			String[] values = value.split(",");
			System.out.println(values[0] + ":begin->");
			for (int i = 0; i < 3; i++) {
				gate.pass(values[0], values[1]);
//				Thread.yield();
			}
		}, "Chris,Canada");
		t3.start();
		Thread t4 = new Thread(() -> {
			String value = Thread.currentThread().getName();
			String[] values = value.split(",");
			System.out.println(values[0] + ":begin->");
			for (int i = 0; i < 3; i++) {
				gate.pass(values[0], values[1]);
//				Thread.yield();
			}
		}, "Alice,Alaska");
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();

	}

}
