package com.design.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
	public static void main(String[] args) {
		FutureTask<String> futureTask = new FutureTask<>(new RealData("query-value"));
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(futureTask);
		System.out.println("----------请求完毕--------------");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("真实数据：" + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
