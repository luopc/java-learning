package com.luopc.thead2.semaphore;

import org.junit.Test;

/**
 * 计数信号量学习
 * @author luopc
 *
 */
public class BoundedSemaphoreTest {

    @Test
    public void test() throws InterruptedException {
        BoundedSemaphore semaphore = new BoundedSemaphore(2);
        for (int i = 0; i < 20; i++) {
            new Thread(new SemaphoreRunable(semaphore, i)).start();
        }
        Thread.sleep(3000);
    }

    @Test
    public void testJdk() throws InterruptedException {
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(2);
        for (int i = 0; i < 20; i++) {
            new Thread(new JdkSemaphoreRunable(semaphore, i)).start();
        }
        Thread.sleep(3000);
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
                System.out.println("[" + user + "]开始执行");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    semaphore.release();
                    System.out.println("[" + user + "]执行结束");
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
                System.out.println("[" + user + "]开始执行");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("[" + user + "]执行结束");

            }

        }

    }

}
