package com.luopc.thead.guarded;

import java.util.Random;

public class ServerThread extends Thread {
	
	private Random random;
	
	private RequestQueue requestQueue;
	
	public ServerThread(RequestQueue requestQueue ,String name,long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Request request = requestQueue.getQueue();
			System.out.println(Thread.currentThread().getName() + " get : " + request.getName());
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
