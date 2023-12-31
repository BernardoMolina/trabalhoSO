package webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int serverAccessCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(80);

        while (true) {
            System.out.println("\nMain| Aguardando requisição...");
            Socket socket = ss.accept();

            serverAccessCount++;
            System.out.println("Main| Conexão recebida: " + serverAccessCount);
            System.out.println("Main| Origem: " + socket.getInetAddress());

            new RequestThread(socket);
        }
    }
}
