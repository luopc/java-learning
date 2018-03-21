package com.luopc.thead2.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程栅栏类学习
 * 
 * @author luopc
 *
 */

class MyCyclicbarrier extends Thread {

    private CyclicBarrier cyclicBarrier;

    public MyCyclicbarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");//2、3执行
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(3, new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");//4、执行

            }
        });
        Thread t1 = new Thread(new MyCyclicbarrier(cb),"T1");
        Thread t2 = new Thread(new MyCyclicbarrier(cb),"T2");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " going to await");//1、步执行
        cb.await();
        System.out.println(Thread.currentThread().getName() + " continue");

    }
}
