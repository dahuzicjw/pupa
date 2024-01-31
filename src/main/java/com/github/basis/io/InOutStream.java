package com.github.basis.io;

import java.io.*;

public class InOutStream {

	static String inPath = "C://unintall.log";
	static String outPath = "c://out.txt";
	static int bufferSize = 1024;
	
	public static void main(String[] args) throws Exception{
		InputStream in = new FileInputStream(inPath);
		OutputStream out = new FileOutputStream(outPath);
		readAndWrite(in, out);
		
	}
	
	public static void readAndWrite(InputStream in, OutputStream out)
	throws IOException{
		byte[] buffer = new byte[bufferSize];
		int readBytes;
		
		int bytesCount = 0;
		while ((readBytes = in.read(buffer)) != -1) {
			for (int i = 0; i < readBytes; i++) {
				System.out.print((char) buffer[i]);
				bytesCount++;
			}
			out.write(buffer, 0, readBytes);
		}
		out.flush();
		out.close();
		System.out.println(bytesCount + "bytes");
	}
}
