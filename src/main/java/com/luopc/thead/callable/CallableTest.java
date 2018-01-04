package com.luopc.thead.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class DataCallable implements Callable<Long> {

	@Override
	public Long call() throws Exception {
		System.out.println(Thread.currentThread().getName() + ",开始计算--------");
		Long count = 0L;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			count += i;
		}
		System.out.println(Thread.currentThread().getName() + ",计算结束--------");
		return count;
	}

}

public class CallableTest {

	public static void main(String[] args) {
		FutureTask<Integer> ft = new FutureTask(new DataCallable());
		new Thread(ft,"zhangsan").start();
		try {
			System.out.println("线程是否结束了:" + ft.isDone());
			System.out.println(ft.get());
			System.out.println("线程是否结束了:" + ft.isDone());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
