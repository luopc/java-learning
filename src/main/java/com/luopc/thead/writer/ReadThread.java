package com.luopc.thead.writer;

public class ReadThread extends Thread {
	private final Data data;

	public ReadThread(Data data) {
		this.data = data;
	}
	public void run() {
		try {
			while(true) {
				char [] readbuf = data.read();
				System.out.println(Thread.currentThread().getName() + " : " + String.valueOf(readbuf));
			}
		}catch(InterruptedException e){
			
		}
	}

}
