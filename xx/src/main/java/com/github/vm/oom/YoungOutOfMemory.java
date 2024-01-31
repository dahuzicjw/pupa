package com.github.vm.oom;

import java.util.ArrayList;

/**
 * MaxTenuringThreshold 控制对象经历多少次Minor GC才晋升到旧生代
 * VM Args : -verbose:gc -Xms20m -Xmx20m XX:MaxTenuringThreshold=8888 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D://dump
 * @author Kevin
 *
 */
public class YoungOutOfMemory {

    public static void main(String[] args) throws Exception {
        ArrayList<YoungOutOfMemory> list = new ArrayList<YoungOutOfMemory>();

        System.in.read();
        while (true) {
            list.add(new YoungOutOfMemory());
        }
    }
}
