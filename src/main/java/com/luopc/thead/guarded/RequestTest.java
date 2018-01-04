package com.luopc.thead.guarded;

public class RequestTest {

	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		new ClientTread(requestQueue, "Alice", 3142564L).start();
		new ServerThread(requestQueue, "Boddy-1", 5248712L).start();
//		new ServerThread(requestQueue, "Boddy-2", 5248712L).start();
	}

}
