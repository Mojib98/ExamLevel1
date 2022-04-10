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

        Thread sender = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                      msg=scanner.nextLine();
                      printWriter.println(msg);
                      printWriter.flush();
            }
        });
        sender.start();
        Thread Resive = new Thread(new Runnable() {
            String mas;

            @Override
            public void run() {
                try {
                    mas = bufferedReader.readLine();
                    while (mas !=null) {
                        System.out.println("massage from clint: " + mas);
                        mas = bufferedReader.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Resive.start();

/*        while (true) {
            String a = scanner.next();
            printWriter.println(a);
            printWriter.flush();
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                System.out.println("you have massege " + str);
            }
        }*/

    }
}
