package com.nio.test.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChannalServerTest {

	private ByteBuffer buffer = ByteBuffer.allocate(1024);
	private IntBuffer intBuffer = buffer.asIntBuffer();
	private SocketChannel clientChannel = null;
	private ServerSocketChannel serverChannel = null;

	public void openChanel() {
		try {
			serverChannel = ServerSocketChannel.open();
			serverChannel.socket().bind(new InetSocketAddress(8888));
			System.out.println("服务已经启动~");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void waitReqConn() {
		while(true) {
			try {
				clientChannel = serverChannel.accept();
				if(null != clientChannel) {
					System.out.println("新的链接接入");
				}
				processReq();
				clientChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	private void processReq() throws IOException {
		System.out.println("开始读取和处理客户端数据...");
		buffer.clear();//准备缓冲区
		clientChannel.read(buffer);//读入客户端的缓冲区
		int result = intBuffer.get(0) + intBuffer.get(1);//
		buffer.flip();//
		buffer.clear();
		intBuffer.put(0, result);//
		clientChannel.write(buffer);//发送给客户端
		System.out.println("读取和处理客户端的数据完成~");
	}
	
	public void start() {		
		openChanel();		
		waitReqConn();		
		try {
			clientChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("服务端处理完成~");
	}
	
	public static void main(String[] args) {
		new ChannalServerTest().start();
	}

}
