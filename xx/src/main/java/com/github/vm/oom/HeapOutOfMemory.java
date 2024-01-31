package com.github.vm.oom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.alibaba.fastjson2.JSONObject;

/**
 * VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D://dump
 * @author Kevin
 *
 */
public class HeapOutOfMemory {
    
    static JSONObject json = new JSONObject();
    static HashMap<String, Object> map = new HashMap<String, Object>();
    static ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
    
    public static void main(String[] args) {
        List<HeapOutOfMemory> list = new ArrayList<HeapOutOfMemory>();
        while (true) {
            list.add(new HeapOutOfMemory());
        }
    }

}
