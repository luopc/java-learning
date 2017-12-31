package com.luopc.thead;

public class X extends Thread implements Runnable {

	public void run() {
		String st = "";
		System.out.println("this is run()");
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new X());
		t.start();
	}
}
