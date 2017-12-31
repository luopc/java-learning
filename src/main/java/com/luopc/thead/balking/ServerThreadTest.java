package com.luopc.thead.balking;

public class ServerThreadTest {

	public static void main(String[] args) {
		Data data = new Data("D:\\java-output\\save.txt", "(empty)");
		new ChangerThread("ChangerThread", data).start();
		new ServerThread("ServerThread", data).start();

	}

}
