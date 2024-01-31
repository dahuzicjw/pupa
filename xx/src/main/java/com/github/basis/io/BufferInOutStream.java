package com.github.basis.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferInOutStream {
    static String inPath     = "C://a.txt";
    static String outPath    = "c://out.txt";
    static int    bufferSize = 1024;

    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream(inPath);
        OutputStream out = new FileOutputStream(outPath);
        long startTime = System.currentTimeMillis();
        readAndWrite(in, out);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        
        startTime = System.currentTimeMillis();
        bufferReadAndWrite(in, out);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
    
    
    public static void bufferReadAndWrite(InputStream in, OutputStream out)
            throws IOException {
        InputStream bin = new BufferedInputStream(in);
        OutputStream bout = new BufferedOutputStream(out);
        
        byte[] buffer = new byte[bufferSize];
        int readBytes;
        
        int bytesCount = 0;
        while ((readBytes = bin.read(buffer)) != -1) {
            bout.write(buffer, 0, readBytes);
        }
        out.flush();
        out.close();
        System.out.println(bytesCount + "bytes");
    }
    
    public static void readAndWrite(InputStream in, OutputStream out)
            throws IOException {
        byte[] buffer = new byte[bufferSize];
        int readBytes;

        int bytesCount = 0;
        while ((readBytes = in.read(buffer)) != -1) {
            for (int i = 0; i < readBytes; i++) {
                // System.out.print((char) buffer[i]);
                bytesCount++;
            }
            out.write(buffer, 0, readBytes);
        }
        out.flush();
        out.close();
        System.out.println(bytesCount + "bytes");
    }
}
