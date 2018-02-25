package com.luopc.thead2.semaphore;

public class BoundedSemaphore {

    private volatile int signals = 0;
    final private int bound;

    public BoundedSemaphore(int upperBound) {
        bound = upperBound;
    }

    public synchronized void take() throws InterruptedException {
        while (this.signals == bound) {
            wait();
        }
        this.signals++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (this.signals == 0) {
            wait();
        }
        this.signals--;
        this.notify();
    }

    public int getSignals() {
        return signals;
    }

    
    
}
