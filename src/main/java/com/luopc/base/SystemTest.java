package com.luopc.base;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Long> {

	@Override
	public Long call() {
		Long va = 0L;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			va += i;
		}
		System.out.println(va);
		return va;
	}

}

public class SystemTest {

	public static void main(String[] args) {
		Long begin = System.currentTimeMillis();
		FutureTask<Long> task = new FutureTask<>(new MyThread());
		new Thread(task).start();
		System.out.println(task.isDone());
		while(!task.isDone()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Long end = System.currentTimeMillis();
		System.out.println("end - begin:" + (end - begin));
		System.out.println(task.isDone());
		
//		SimpleDateFormat
	}

}
