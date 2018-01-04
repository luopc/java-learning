package com.luopc.thead.test01;

public class PrintRunnable implements Runnable {
	
	private String message;
	

	public PrintRunnable(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.print(message);
		}
		
	}

}
