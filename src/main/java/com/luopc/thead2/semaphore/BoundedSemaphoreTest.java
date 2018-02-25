package com.luopc.thead2.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 计数信号量学习
 * @author luopc
 *
 */
public class BoundedSemaphoreTest {
    
    public static void main(String[] args) {        
        ExecutorService es = Executors.newCachedThreadPool();
        BoundedSemaphore semaphore = new BoundedSemaphore(2);
        for (int i = 0; i < 20; i++) {
            es.execute(new BoundedSemaphoreTest().new SemaphoreRunable(semaphore, i));
        }
        es.shutdown();
   
//        ExecutorService es2 = Executors.newCachedThreadPool();
//        java.util.concurrent.Semaphore smh = new java.util.concurrent.Semaphore(2);
//        for (int i = 0; i < 20; i++) {
//            es2.execute(new BoundedSemaphoreTest().new JdkSemaphoreRunable(smh, i));
//        }
//        es2.shutdown();
    }

    /**
     * 执行任务类
     * 
     * @author luopc
     *
     */
    class SemaphoreRunable implements Runnable {

        BoundedSemaphore semaphore;// 定义信号量

        private int user;// 第几个用户

        public SemaphoreRunable(BoundedSemaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                semaphore.take();
                System.out.println("[" + user + "]开始执行，当前的single=" + semaphore.getSignals());
                Thread.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    semaphore.release();
                    System.out.println("[" + user + "]执行结束，当前的single=" + semaphore.getSignals());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    /**
     * 执行任务类
     * 
     * @author luopc
     *
     */
    class JdkSemaphoreRunable implements Runnable {

        java.util.concurrent.Semaphore semaphore;// 定义信号量

        private int user;// 第几个用户

        public JdkSemaphoreRunable(java.util.concurrent.Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("[" + user + "]开始执行，当前的single=" + semaphore.getQueueLength());
                Thread.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("[" + user + "]执行结束，当前的single=" + semaphore.getQueueLength());

            }

        }

    }

}
