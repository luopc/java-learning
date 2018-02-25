package com.luopc.thead2.countDownLatch;

import java.util.concurrent.CountDownLatch;

class CountDownLatchDemo {

    public static void main(String[] args) {
        int maxNum = 6;
        final CountDownLatch latch = new CountDownLatch(maxNum);

        for (int i = 0; i < 12; i++) {
            final int user = i + 1;
            Runnable r = () -> {
                System.out.printf("任务[%d]正在执行任务\r\n", user);
                try {
                    Thread.sleep(((long) (Math.random() * 10000)));
                    System.out.printf("任务[%d]完成\r\n", user);
                    latch.countDown();// 重要标志
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(r).start();
        }

        System.out.printf("等待其他[%d]个任务执行完毕，主线程才开始执行任务：" + Thread.currentThread().getName(), maxNum);
        try {
            latch.await();// 阻塞->执行到countDown再执行后面
            System.out.println("主线程开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
