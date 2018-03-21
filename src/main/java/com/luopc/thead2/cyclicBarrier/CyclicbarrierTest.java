package com.luopc.thead2.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 栅栏Cyclibarrier学习
 * @author luopc
 *
 */
public class CyclicbarrierTest {

    public static void main(String[] args) {
     
        final CyclicBarrier cb = new CyclicBarrier(3, () -> {
            System.out.println("栅栏调用结束~");
        });

        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            final String user = "No." + (i + 1);
            es.execute(() -> {
                try {
                    Thread.sleep(((long) (Math.random() * 10000)));
                    System.out.println(user + "已经到达,共有"+ (cb.getNumberWaiting() + 1) + "人。");
                    cb.await();//阻塞
                    if ("No.1".equals(user)) {
                        System.out.println("三个人已经集合完毕，可以开始打牌了~");
                    }
                    
                    //-----------------------第二轮栅栏
                    Thread.sleep(((long) (Math.random() * 5000)));                    
                    System.out.println(user + "准备出牌~");
                    cb.await();
                    if ("No.1".equals(user)) {
                        System.out.println("出完了第一轮牌~");
                    }
                    
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();

    }
}
