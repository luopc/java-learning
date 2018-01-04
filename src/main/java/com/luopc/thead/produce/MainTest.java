package com.luopc.thead.produce;

public class MainTest {

	public static void main(String[] args) {
		Table table = new Table(3);
		new MakerThread("厨师-1", table).start();
//		new MakerThread("厨师-2", table).start();
//		new MakerThread("厨师-3", table).start();
		new EaterThread("顾客-①", table).start();
//		new EaterThread("顾客-②", table).start();
//		new EaterThread("顾客-③", table).start();

	}

}
