package com.luopc.thead2.semaphore;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * 计数信号量学习
 * 
 * @author luopc
 *
 */
public class CountingSemaphoreTest {
    
    private CountDownLatch latch = new CountDownLatch(10);

    @Test
    public void test() {
        final CountingSemaphore cs = new CountingSemaphore();
        for (int i = 0; i < 10; i++) {
            new Thread(new CountingSemaphoreRunable(cs), "No." + (i + 1)).start();
        }
        try {
            latch.await();
            System.out.println("执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        


    }

    class CountingSemaphoreRunable implements Runnable {


        private CountingSemaphore semaphore;

        public CountingSemaphoreRunable(CountingSemaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            semaphore.take();
            System.out.println("当前[" + Thread.currentThread().getName() + "]有多少个在执行：" + semaphore.getSignals());
            try {
                Random rd = new Random();
                int sleepTime = ((int) rd.nextInt(100));
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    semaphore.release();
                    System.out.println("当前[" + Thread.currentThread().getName() + "]结束后有多少个在执行：" + semaphore.getSignals());
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
