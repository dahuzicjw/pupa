package com.github.basis.io;

import java.io.*;

public class StringBufferStream {

	static String inPath = "C://unintall.log";
	static String outPath = "c://out.txt";
	static int bufferSize = 1024;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(inPath));
		br.close();
	}
	
	public static void readAndWrite(BufferedReader in, BufferedWriter out)
			throws IOException{
		String str;
		
		while ((str = in.readLine()) != null ) {
			System.out.println(str);
		}
	}

}
