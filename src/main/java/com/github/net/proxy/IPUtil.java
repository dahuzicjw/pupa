package com.github.net.proxy;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author chenjw
 * @Date 2017年02月09日
 */
public class IPUtil {

    public static void main(String[] args) {
        System.out.println(getIP());
        setIP("192.168.116.254");
        System.out.println(getIP());
        ipConfig();
    }

    public static String getIP() {
        String Ip = null;
        try {
            Ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return Ip;
    }

    /**
     * newIP - 要修改的ip
     **/
    public static void setIP(String newIP) {
        try {
            String localConnectivity = "本地连接";
            String subnetMask = "255.255.255.0";
            String defaultGateway = "192.168.116.1";
            String defaultGatewayCount = "1"; // 1 －默认网关的跃点数。如果网关设置为 ’none’，则不应设置此字段。
            String command = "netsh interface ip set addr \"" + localConnectivity + "\" " +
                    "static " + newIP + " " + subnetMask + " " + defaultGateway + " " + defaultGatewayCount; // static - 设置使用本地静态配置设置IP地址。
            System.out.println(command);
            Process exec = Runtime.getRuntime().exec(command);
            byte[] bytes = new byte[1024];
            InputStream inputStream = exec.getInputStream();
            while (inputStream.read(bytes) > 0) {
                System.out.println(new String(bytes, "gbk"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ipConfig() {
        try {
            Process process = Runtime.getRuntime().exec("ipconfig");
            InputStream in = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "gbk"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
