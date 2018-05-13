package com.luopc.socket.thread;

import java.net.Socket;

public class HandleThread extends Thread{

	private Socket socket;

	public HandleThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// Socket处理代码
		System.out.println("线程处理请求~");
	}

}
