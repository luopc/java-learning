package com.luopc.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService {

    public static int port = 4343; //端口号

    public static void main(String[] args) {

        Thread serverService = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    Socket socket = serverSocket.accept();
                    Thread handleTread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try (BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                 PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                                printWriter.println("received msg from server.");
                                //String s = bf.readLine();
                                //printWriter.println(s);
                                printWriter.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    handleTread.start();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        serverService.start();
        System.out.println("-------------- Server started completed-----------");
    }

}
