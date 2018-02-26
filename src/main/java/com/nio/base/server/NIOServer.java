package com.nio.base.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    /**
     * 接收数据缓冲区
     */
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    /**
     * 发送数据缓冲区
     */
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

    private Selector selector;

    /**
     * 注册服务
     * 
     * @param port
     */
    public NIOServer(int port) {
        try {
            // 打开服务器套接字通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);// 服务器配置为非阻塞
            // 检索与此通道关联的服务器套接字
            ServerSocket serverSocket = channel.socket();
            serverSocket.bind(new InetSocketAddress(port));// 进行服务绑定
            // 通过open方法找到Selector
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);// 注册到selector，等待链接
            System.out.println("Server start~~~~");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listen() throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleKey(selectionKey);
            }
        }
    }

    private void handleKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel server = null;
        SocketChannel client = null;
        String receiveText;
        String sendText;
        int count = 0;

        if (selectionKey.isAcceptable()) {
            // 返回为之创建此键的通道。
            server = (ServerSocketChannel) selectionKey.channel();
            // 接受到此通道套接字的连接。
            // 此方法返回的套接字通道（如果有）将处于阻塞模式。
            client = server.accept();
            // 配置为非阻塞
            client.configureBlocking(false);
            // 注册到selector，等待连接
            client.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            // 返回为之创建此键的通道。
            client = (SocketChannel) selectionKey.channel();
            // 将缓冲区清空以备下次读取
            receiveBuffer.clear();
            // 读取服务器发送来的数据到缓冲区中
            count = client.read(receiveBuffer);
            if (count > 0) {
                receiveText = new String(receiveBuffer.array(), 0, count);
                System.out.println("服务器端接受客户端数据--:" + receiveText);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (selectionKey.isWritable()) {
            // 将缓冲区清空以备下次写入
            sendBuffer.clear();
            // 返回为之创建此键的通道。
            client = (SocketChannel) selectionKey.channel();
            sendText = "message from server--";
            // 向缓冲区中输入数据
            sendBuffer.put(sendText.getBytes());
            // 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
            sendBuffer.flip();
            // 输出到通道
            client.write(sendBuffer);
            System.out.println("服务器端向客户端发送数据--：" + sendText);
            client.register(selector, SelectionKey.OP_READ);
        }

    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        NIOServer server = new NIOServer(port);
        server.listen();
    }

}
