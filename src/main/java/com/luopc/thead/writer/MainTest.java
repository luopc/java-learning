package com.luopc.thead.writer;

public class MainTest {

	public static void main(String[] args) {
		Data data = new Data(10);
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		
		new WriterThread(data,"ABCDEFGHJKMNOPQWXYZ").start();
		new WriterThread(data,"abcdefghjkmnopqwxyz").start();
	}

}
