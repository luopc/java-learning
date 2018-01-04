package com.luopc.thead.balking;

import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {

	private Data data;

	public ChangerThread(String name, Data data) {
		super(name);
		this.data = data;
	}

	private Random random= new Random();

	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				data.change("NO." + i);
				Thread.sleep(random.nextInt(1000));
				data.save();
			} catch ( IOException | InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
