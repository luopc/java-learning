package com.luopc.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientIo {
	public static void main(String[] args) {
		BufferedReader bf = null;
		PrintWriter pw = null;
		try {
			Socket socket = new Socket("127.0.0.1", 9200);
			bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);			
			pw.println("hello server");
			String s = null;
			while(true) {
				s = bf.readLine();
				if(s != null) {
					break;
				}
			}
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.close();
		}
	}
}
