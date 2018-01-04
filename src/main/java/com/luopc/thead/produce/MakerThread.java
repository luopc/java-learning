package com.luopc.thead.produce;

import java.util.Random;

public class MakerThread extends Thread {

	private final Table table;
	private final String name;

	public MakerThread(String name, Table table) {
		super(name);
		this.name = name;
		this.table = table;
	}

	private final Random random = new Random();
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(random.nextInt(100));
				table.put("[No." + i + " cake] by " + name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
