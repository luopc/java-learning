package com.luopc.thead.guarded;

import java.util.Random;

public class ClientTread extends Thread {
	
	
	private Random random;
	
	private RequestQueue requestQueue;
	
	public ClientTread(RequestQueue requestQueue ,String name,long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Request request = new Request("NO." + i);
			System.err.println(Thread.currentThread().getName() + " put : " + request.getName());
			requestQueue.putQueue(request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
