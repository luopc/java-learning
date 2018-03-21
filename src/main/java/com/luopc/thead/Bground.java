package com.luopc.thead;

public class Bground extends Thread {
	{
		System.out.println("----------6--------");
	}
	public static void main(String argv[]) {
		System.out.println("----------1--------");
		Bground b = new Bground();
		System.out.println("----------2--------");
		b.run();
//		b.start();
		System.out.println("----------5--------");
	}

	public void start() {
		System.out.println("----------3--------");
		for (int i = 0; i < 10; i++) {
			System.out.println("Value of i = " + i);
		}
		System.out.println("----------4--------");
		
	}

}
