package com.github.basis.io;

import java.io.*;

public class ReaderWriterStream {

	static String inPath = "C://unintall.log";
	static String outPath = "c://out.txt";
	static int bufferSize = 1024;

	public static void main(String[] args) throws Exception {
		Reader in = new FileReader(inPath);
		Writer out = new FileWriter(outPath);
		readAndWrite(in, out);
		
		BufferedReader br = new BufferedReader(new FileReader(inPath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));
		readAndWrite(br, bw);
	}

	private static void readAndWrite(Reader in, Writer out) throws IOException {
		char[] buffer = new char[bufferSize];
		int readChars;
		while ((readChars = in.read(buffer)) != -1) {
			System.out.println(buffer);
			out.write(buffer, 0, readChars);
		}
		out.flush();
		out.close();
	}
	
	private static void readAndWrite(BufferedReader br, BufferedWriter bw)
			throws IOException{
		String str;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
			bw.write(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
