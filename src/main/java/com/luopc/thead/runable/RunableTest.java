package com.luopc.thead.runable;

class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ",I am Run!");
	}

}

public class RunableTest {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		new Thread(myThread, "lisi").start();
	}

}
