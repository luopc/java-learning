package com.luopc.thead.produce;

import java.util.Random;

public class EaterThread extends Thread {

	private final Table table;

	public EaterThread(String name, Table table) {
		super(name);
		this.table = table;
	}

	private final Random random = new Random();

	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				String cake = table.get();
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
