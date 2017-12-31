package com.luopc.thead.writer;

import java.util.Random;

public class WriterThread extends Thread {

	private static final Random random = new Random();

	private final Data data;

	private final String filler;

	private int index = 0;

	public WriterThread(Data data, String str) {
		this.data = data;
		this.filler = str;
	}

	public void run() {
		try {
			while (true) {
				char c = nextchar();
				data.writer(c);
				Thread.sleep(random.nextInt(50));
			}
		} catch (InterruptedException e) {

		}
	}

	private char nextchar() {
		char c = filler.charAt(index);
		index++;
		if (index >= filler.length()) {
			index = 0;
		}
		return c;
	}

}
