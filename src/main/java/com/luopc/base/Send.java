package com.luopc.base;



public class Send{
	
	public static void main(String[] args) throws InterruptedException {
		Runnable ru = new Runnable() {		
			@Override
			public void run() {
				System.out.println("123456");
				System.out.println("123456");
				System.out.println("123456");
				System.out.println("123456");
			}
		};
		
		Thread th = new Thread(ru);
		th.start();
		th.join();
		System.out.println("end");
		
		Thread th2 = new Thread(()-> System.out.println("123456")) ;
		th2.start();
		th2.join();
		System.out.println("end2");
		
		Runnable ru2 = ()-> System.out.println("123456");
		
		Runnable ru3 = () -> {
			System.out.println("123456");
			System.out.println("123456");
			System.out.println("123456");
			System.out.println("123456");
		};
		
	}
}