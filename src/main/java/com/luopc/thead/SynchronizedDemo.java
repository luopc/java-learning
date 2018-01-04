package com.luopc.thead;

public class SynchronizedDemo {

	private boolean ready = false;
	private int result = 0;
	private int number = 1;

	public void write() {
		ready = true;
		number = 2;
	}

	public void read() {
		if (ready) {
			result = number * 3;
		}
		System.out.println("result = " + result);
	}

	private class WriteReadThread extends Thread {
		private boolean flag;

		public WriteReadThread(boolean flag) {
			this.flag = flag;
		}

		@Override
		public void run() {
			if (flag) {
				write();
			} else {
				read();
			}

		}

	}

	public static void main(String[] args) {
		SynchronizedDemo demo = new SynchronizedDemo();
//		for (int i = 0; i < 1000; i++) {
			demo.new WriteReadThread(true).start();
			demo.new WriteReadThread(false).start();
//		}
	}

}
