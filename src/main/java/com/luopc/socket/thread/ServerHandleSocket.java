package com.luopc.socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandleSocket {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;

		try {
			// 实例化一个服务器端的Socket连接
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			System.err.print("Could not listen on port:9999");
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			while (true) {
				// 用于接收来自客户端的连接
				clientSocket = serverSocket.accept();
				new HandleThread(clientSocket).start();
			}
		} catch (IOException e) {
			System.err.println("Accept failed");
			System.exit(1);
		}
	}

}
