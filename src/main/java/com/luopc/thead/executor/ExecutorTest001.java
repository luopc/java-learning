package com.luopc.thead.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTestThread extends Thread {

	private final int value;

	public MyTestThread(int i) {
		this.value = i;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + value);
	}
}

public class ExecutorTest001 {

	public static void main(String[] args) {
		ExecutorService executor ;
//		executor = Executors.newCachedThreadPool();// 根据计算机创建一个无限制的线程池
//		executor = Executors.newSingleThreadExecutor();//只创建一个线程池
		executor = Executors.newFixedThreadPool(5);//只创建一个固定大小的线程池
//		executor = Executors.newScheduledThreadPool(5);//核心固定
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			executor.submit(new MyTestThread(i));
		}
		executor.shutdown();
	}

}
