package com.github.net.tcp;

import com.alibaba.dubbo.common.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        post();
    }

    private static JSONObject post() {
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 6666);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.write("test");
            writer.flush();
            socket.shutdownOutput();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String buffer;
            while ((buffer = br.readLine()) != null) {
                System.out.println(buffer);
            }
            writer.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
