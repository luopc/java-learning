package com.luopc.thead2.semaphore;

public class ReceivingThread extends Thread {
    
    Semaphore semaphore;

    public ReceivingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    
    public void run() {
        while(true) {
            try {
                this.semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

}
