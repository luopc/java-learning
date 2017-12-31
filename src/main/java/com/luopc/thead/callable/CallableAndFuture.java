package com.luopc.thead.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static class CallM implements Callable<String> {
		@Override
		public String call() throws Exception {
			return "start call;";
		}

	}

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Future<String> future = threadPool.submit(new CallM());
		System.out.println("--------------");
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

