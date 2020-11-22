package com.luopc.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerIo {

    public static void main(String[] args) {
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            ServerSocket server = new ServerSocket(9200);
            Socket socket = server.accept();
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);
            String s = bf.readLine();
            pw.println(s);
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
