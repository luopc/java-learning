package com.luopc.thead.prel;

public class Helper {

	public void handle(int count, char c) {
		System.out.println(" handle (" + count + ", "+ c + " ) Begin");
		for (int i = 0; i < count; i++) {
			slowly();
			System.out.print(c);
		}
		System.out.println("");
		System.out.println(" handle (" + count + ", "+ c + " ) End");
	}

	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
