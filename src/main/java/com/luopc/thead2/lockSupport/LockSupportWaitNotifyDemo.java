package com.luopc.thead2.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用Support来实现阻塞和唤醒
 * @author luopc
 *
 */

class MySupportThread extends Thread{
    
    private Object lock;

    public MySupportThread(Object lock) {
        super();
        this.lock = lock;
    }
    
    
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) lock));
        // 释放许可
        LockSupport.unpark((Thread) lock);
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) lock));

        System.out.println("after unpark");
    }
}

public class LockSupportWaitNotifyDemo {

    public static void main(String[] args) {
        MySupportThread myThread =  new MySupportThread(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }

}
