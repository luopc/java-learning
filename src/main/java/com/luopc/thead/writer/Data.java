package com.luopc.thead.writer;

public class Data {

	private final char[] buffchar;

	private final ReadWriterLock lock = new ReadWriterLock();

	public Data(int size) {
		this.buffchar = new char[size];
		for (int i = 0; i < buffchar.length; i++) {
			buffchar[i] = '*';
		}
	}

	public char[] read() throws InterruptedException {
		lock.readLock();
		try {
			return doRead();
		} finally {
			lock.unReadLock();
		}

	}

	public void writer(char c) throws InterruptedException {
		lock.writerLock();
		try {
			doWriter(c);
		} finally {
			lock.unWriterLock();
		}
	}

	private char[] doRead() {
		char[] newbuff = new char[buffchar.length];
		for (int i = 0; i < buffchar.length; i++) {
			newbuff[i] = buffchar[i];
		}
		showly();
		return newbuff;
	}

	private void showly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void doWriter(char c) {
		for (int i = 0; i < buffchar.length; i++) {
			buffchar[i] = c;
			showly();
		}
	}

}
