package com.luopc.thead2.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private static final int THRESHOLD = 2;// 阈值

	private int start;

	private int end;

	public RecursiveTaskDemo(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 如果任务大于阀值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			RecursiveTaskDemo leftTask = new RecursiveTaskDemo(start, middle);
			RecursiveTaskDemo rightTask = new RecursiveTaskDemo(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();
			// 等待子任务执行完，并得到其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;
		}

		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		RecursiveTaskDemo task = new RecursiveTaskDemo(1, 4);
		Future<Integer> future = forkJoinPool.submit(task);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
