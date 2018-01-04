package com.luopc.thead.writer;

public class ReadWriterLock {
	
	private int readingReaders = 0;
	
	private int waitingWriters = 0;
	
	private int writingWriters = 0;
	
	private boolean preferWriter = true;
	

	public synchronized void readLock() throws InterruptedException{
		while(writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
			wait();
		}
		readingReaders ++;
	}

	public synchronized void unReadLock() {
		readingReaders --;
		preferWriter = true;
		notifyAll();
	}

	public synchronized void writerLock() throws InterruptedException {
		waitingWriters ++;
		try{
			while(writingWriters > 0 || readingReaders > 0) {
				wait();
			}
		}finally {
			waitingWriters --;
		}
		writingWriters ++;
	}

	public synchronized void unWriterLock() {
		writingWriters --;
		preferWriter = false;
		notifyAll();
	}
	
	
	

}
