package com.luopc.thead2.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * http://www.cnblogs.com/dolphin0520/p/3932921.html
 * @author cheng
 *
 */
public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		/**
		 * corePoolSize:创建的线程池大小
		 * maximumPoolSize:线程池最大大小
		 * keepAliveTime:线程活动的保持时间
		 * unit:线程活动保持时间的单位——TimeUnit.DAYS;TimeUnit.MICROSECONDS;TimeUnit.SECONDS;TimeUnit.HOURS;TimeUnit.MINUTES;
		 * workQueue:任务队列——ArrayBlockingQueue;LinkedBlockingQueue;SynchronousQueue;
		 * threadFactory:创建线程的工厂
		 * handle:饱和策略
		 */
//		ThreadPoolExecutor tpe = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,threadFactory,handle);
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();

	}

}
class MyTask implements Runnable {
    private int taskNum;
     
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}