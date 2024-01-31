package com.github.basis.io.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

    static String infile = "C:\\in.f4v";
//  static String infile = "C:\\b.gif";
    static String outfile = "C:\\copy.gif";
    static int    bufferSize = 1024;
    
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        bufferReadAndWrite(new FileInputStream(infile), new FileOutputStream(outfile));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        readAndWrite();
        endTime = System.nanoTime();
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
    
    public static void readAndWrite() throws Exception {
        // 获取源文件和目标文件的输入输出流
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        // 获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            // clear方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();
            // 从输入通道中将数据读到缓冲区
            int r = fcin.read(buffer);
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
            if (r == -1) {
                break;
            }
            // flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            // 从输出通道中将数据写入缓冲区
            fcout.write(buffer);
        }
//        int readBufferSize = 0;
//        while ((readBufferSize = fcin.read(buffer)) != -1) {
//            buffer.flip();
//            fcout.write(buffer);
//            buffer.clear();
//        }
        fin.close();
        fout.close();
    }
}