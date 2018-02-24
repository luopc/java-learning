package com.luopc.thead2.semaphore;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * 计数信号量学习
 * @author luopc
 *
 */
public class CountingSemaphoreTest {

    @Test
    public void test() {
        CountingSemaphore semaphore = new CountingSemaphore();
        for (int i = 0; i < 10; i++) {
            new Thread(new CountingSemaphoreRunable(i, semaphore)).start();
        }
        
        
    }

    class CountingSemaphoreRunable implements Runnable {

        private int user;

        private CountingSemaphore semaphore;

        public CountingSemaphoreRunable(int user, CountingSemaphore semaphore) {
            this.user = user;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            semaphore.take();
            System.out.println("当前[" + user + "]有多少个在执行：" + semaphore.getSignals());
            try {
                
                Random rd = new Random();
                int sleepTime = ((int)rd.nextInt(100));
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                try {
                    semaphore.release();
                } catch (InterruptedException e) {
                    System.err.println("----------");
                    e.printStackTrace();
                }finally {
                    System.out.println("当前[" + user + "]结束后有多少个在执行：" + semaphore.getSignals());
                }
               
            }
        }

    }

}
