package com.home.lab11.task2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args[]) {
        try {
            int serverPort = 6789;
            ServerSocket listenSocket =
                    new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch(IOException e) {
            System.out.println("Listen socket:"+e.getMessage());
        }

    }
}
