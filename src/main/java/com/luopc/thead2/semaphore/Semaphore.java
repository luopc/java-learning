package com.luopc.thead2.semaphore;

public class Semaphore {

    private boolean signal = false;

    public synchronized void take() {
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (!this.signal)
            wait();
        this.signal = false;
    }

}
