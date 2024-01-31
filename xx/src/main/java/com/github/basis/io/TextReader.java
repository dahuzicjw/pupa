package com.github.basis.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class TextReader {

	public static void main(String[] args) throws Exception {
		// String path = "C://a.txt";
//		String path = "C://TimeEventNSIS.log";
//		int bufferSize = 1024;
		String outPath = "c://out.txt";
		// String path = "C://pic.gif";
//		File file = new File(path);

//		InputStream in = new FileInputStream(path);
//		OutputStream out = new FileOutputStream(outPath);
////		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		inOutStream(in, out, bufferSize);
		
//		FileReader in = new FileReader(path);
////		FileWriter out = new FileWriter(outPath);
//		StringWriter out = new StringWriter();
//		readWriter(in, out, bufferSize);
		
		BufferedWriter out = new BufferedWriter(new FileWriter(outPath));
		Scanner sc = new Scanner(System.in);
		String str;
		while(true){
			str = sc.next();
			if("`".equals(str))
				break;
			out.write(str);
			out.newLine();
		}
		sc.close();
		out.flush();
		out.close();
	}

	public static void inOutStream(InputStream in, OutputStream out,
			int bufferSize) throws Exception {
		byte[] buffer = new byte[bufferSize];
		int bytesRead;
		while((bytesRead = in.read(buffer)) != -1){
			out.write(buffer, 0, bytesRead);
		}
	}

	public static void readWriter(Reader in, Writer out, int bufferSize)
	throws IOException{
		int charsRead;
		char[] cs = new char[bufferSize];
		while((charsRead = in.read(cs)) != -1){
			out.write(cs, 0 ,charsRead);
		}
		out.flush();
		out.close();
	}
	
}
