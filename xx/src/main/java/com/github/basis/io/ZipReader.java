package com.github.basis.io;

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader {

    static String path = "d://input/input.zip";
    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        ZipInputStream in = new ZipInputStream(new FileInputStream(path));
//        System.out.println(in);
        ZipEntry nextEntry;
        
        while ((nextEntry = in.getNextEntry()) != null) {
            System.out.println(nextEntry.getName());
//            nextEntry.
//            InputStream ins = new ZipFile(nextEntry.getName()).getInputStream(nextEntry);
//            byte[] buffer = null;
//            int i;
//            while ((i = ins.read(buffer)) > 0) {
//                System.out.println(buffer);
//            }
        }
    }
}
