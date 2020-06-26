package com.luopc.socket.simple;

import com.luopc.socket.simple.tools.HandlerExecutorPool;
import com.luopc.socket.simple.tools.ServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            // 实例化一个服务器端的Socket连接
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.err.print("Could not listen on port:9999");
            System.exit(1);
        }
        System.out.println("Server start!");
        Socket clientSocket = null;
        try {
            // 用于接收来自客户端的连接
            clientSocket = serverSocket.accept();
            System.out.println("---------------开始接收请求-------------");
            HandlerExecutorPool executor = new HandlerExecutorPool(50,1000);
            executor.execute(new ServerHandler(clientSocket));
        } catch (IOException e) {
            System.err.println("Accept failed");
            System.exit(1);
        }

        // 客户端有数据了就向屏幕打印Hello World
        System.out.print("Hello World");
        clientSocket.close();
        serverSocket.close();
    }
}
