package com.cmy.basis.io.nio;

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
//	static String infile = "C:\\b.gif";
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
    	// ��ȡԴ�ļ���Ŀ���ļ������������
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        // ��ȡ�������ͨ��
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // ����������
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            // clear�������軺������ʹ�����Խ��ܶ��������
            buffer.clear();
            // ������ͨ���н����ݶ���������
            int r = fcin.read(buffer);
            // read�������ض�ȡ���ֽ���������Ϊ�㣬�����ͨ���ѵ�������ĩβ���򷵻�-1
            if (r == -1) {
                break;
            }
            // flip�����û��������Խ��¶��������д����һ��ͨ��
            buffer.flip();
            // �����ͨ���н�����д�뻺����
            fcout.write(buffer);
        }
//        int readBufferSize = 0;
//        while ((readBufferSize = fcin.read(buffer)) != -1) {
//            buffer.flip();
//            fcout.write(buffer);
//            buffer.clear();
//        }
    }
}