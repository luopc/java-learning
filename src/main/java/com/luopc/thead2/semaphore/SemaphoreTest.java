package com.luopc.thead2.semaphore;

/**
 * 计数信号量学习
 * @author luopc
 *
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        SendingThread sender = new SendingThread(semaphore);
        ReceivingThread receiver = new ReceivingThread(semaphore);
        receiver.start();
        sender.start();
    }

}
