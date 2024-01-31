package com.github.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        Server tcpServer = new Server();
        tcpServer.server();
    }
    
    public void server() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(6666);
            while (true) {
                listen(serverSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void listen(ServerSocket serverSocket) {
        Socket accept;
        try {
            accept = serverSocket.accept();
            handle(accept);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void handle(Socket accept) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStreamWriter out = null;
        try {
            isr = new InputStreamReader(accept.getInputStream());
            br = new BufferedReader(isr);
            String buffer;
            while ((buffer = br.readLine()) != null) {
                System.out.println(buffer);
            }
            accept.shutdownInput();
            out = new OutputStreamWriter(accept.getOutputStream());
            out.write("out");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (br != null)
                    br.close();
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
    
}
