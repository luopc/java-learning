package com.luopc.thead2.semaphore;

public class SendingThread extends Thread {

    Semaphore semaphore = null;
    
    public SendingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    public void run() {
        while(true) {
            this.semaphore.take();
        }
    }
    
    
}
