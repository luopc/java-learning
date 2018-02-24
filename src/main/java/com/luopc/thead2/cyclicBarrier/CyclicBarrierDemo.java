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
        System.out.println(Thread.currentThread().getName() + " going to await");
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
        CyclicBarrier cb = new CyclicBarrier(3, new Thread("barrierAction") {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");

            }
        });
        Thread t1 = new Thread(new MyCyclicbarrier(cb),"T1");
        Thread t2 = new Thread(new MyCyclicbarrier(cb),"T2");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " going to await");
        cb.await();
        System.out.println(Thread.currentThread().getName() + " continue");

    }
}
