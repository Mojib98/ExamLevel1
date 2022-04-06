package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("server connection");
        ServerSocket serverSocket = new ServerSocket(13303);
        Socket socket = serverSocket.accept();
        System.out.println("read date");
        OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter printWriter = new PrintWriter(outputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
                String str = bufferedReader.readLine();
                System.out.println("date is " + str);
                if (bufferedReader.ready()){
                    continue;
                }
            String a = scanner.next();
            printWriter.println(a);
            printWriter.flush();
        }
     /*   OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("helll");
        printWriter.flush();*/

    }
}
