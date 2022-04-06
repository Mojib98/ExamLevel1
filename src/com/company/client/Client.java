package com.company.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    String host="localhost";
    Integer port=9999;
    Socket socket = new Socket(host,port);


    public Client() throws IOException {
    }
    public void client() throws IOException {
     /*   OutputStream outputStream = OutputStream.nullOutputStream(socket.getOutputStream());
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("hhhhhh");*/

    }

}

