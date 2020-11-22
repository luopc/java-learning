package com.luopc.io.aio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class AIOServer {

    public static int port = 4345; //端口号

    public static void main(String[] args) {
        ExecutorService serverThread = Executors.newFixedThreadPool(5);
        serverThread.submit(() -> {
                    AsynchronousChannelGroup group = null;
                    try {
                        group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
                        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                            @Override
                            public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                                server.accept(null, this); // 接收下一个请求
                                try {
                                    Future<Integer> f = result.write(Charset.defaultCharset().encode("你好，世界"));
                                    f.get();
                                    System.out.println("服务端发送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                                    result.close();
                                } catch (InterruptedException | ExecutionException | IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

                            }
                        });
                        group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

}
