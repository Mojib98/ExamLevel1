package com.company.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Client {

    public static void main(String[] args) throws IOException {
        // write your code here
        try {
            Scanner scanner = new Scanner(System.in);
            String host = "localhost";
            int port = 29999;
//            Socket socket = new Socket("127.0.0.1", 5000);
            int i = 5000;
            System.out.println(InetAddress.getLocalHost().getHostName());
            Socket socket = new Socket(InetAddress.getLocalHost().getHostName(),13303);
            OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter printWriter = new PrintWriter(outputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String a = scanner.next();
                printWriter.println(a);
                printWriter.flush();
                    String str = bufferedReader.readLine();
                    System.out.println("you have massege " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
