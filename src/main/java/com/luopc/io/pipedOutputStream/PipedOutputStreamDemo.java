package com.luopc.io.pipedOutputStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedOutputStreamDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);

		Thread tout = new Thread(() -> {
			try {
				pos.write("Hello word,piped!".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		tout.start();
		Thread tin = new Thread(() -> {
			try {
				int data = pis.read();
				while(data!=-1) {
					System.out.print((char)data);
					data = pis.read();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					pis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		tin.start();
		
		tout.join();
		tin.join();
	}

}
