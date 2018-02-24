package com.luopc.thead2.condition;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过condition实现生产消费模型
 * 
 * @author luopc
 *
 */
public class ReentrantLockConditionDemo {

    private Lock theLock = new ReentrantLock();
    // 消费者用判断条件
    private Condition full = theLock.newCondition();
    // 生产者用判断条件
    private Condition empty = theLock.newCondition();

    /**
     * 生产者
     * 
     * @throws InterruptedException
     */
    public void provider(List<String> products, int maxNum) throws InterruptedException {
        theLock.lock();
        try {
            while (!Thread.interrupted()) {
                if (products.size() == maxNum) {
                    System.out.println("库存已满~");
                    full.await();
                } else {
                    Random rd = new Random();
                    String product = "NO." + rd.nextInt(maxNum * 10);
                    System.out.println("仓库新增了；" + product);
                    products.add(product);
                    // 已经生产了产品，提示其他客户进行消费
                    empty.signal();
                }
            }
        } finally {
            theLock.unlock();
        }

    }

    /**
     * 消费者
     */
    public void consumer(List<String> products) {

        try {
            while (!Thread.interrupted()) {
                // 获得锁
                theLock.lock();
                if (products.size() == 0) {
                    System.out.println("仓库现在是空的了");
                    try {
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    String product = products.remove(0);
                    System.out.println(product + "已经被消费掉了~");
                    full.signal();
                }
            }
        } finally {
            theLock.unlock();
        }
    }

    public static void main(String[] args) {
        List<String> products = new LinkedList<>();
        final ReentrantLockConditionDemo demo = new ReentrantLockConditionDemo();
        Thread d1 = new Thread(() -> {
            try {
                demo.provider(products, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread d2 = new Thread(() -> {
            demo.consumer(products);
        });

        d1.start();
        d2.start();
        try {
            Thread.sleep(200);
            // d1.interrupt();
            // d2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
