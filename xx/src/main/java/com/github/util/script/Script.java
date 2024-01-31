package com.github.util.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Script {

    public static void main(String[] args) {
        eval("10000000000+1111111111111111111111");
    }

    private static final ScriptEngine engine;
    static {
        engine = new ScriptEngineManager().getEngineByExtension("js");

        try {
            String scriptMAX = "function MAX(VAL1,VAL2){ return Math.max(VAL1,VAL2);}";
            engine.eval(scriptMAX);
            String scriptMIN = "function MIN(VAL1,VAL2){ return Math.min(VAL1,VAL2);}";
            engine.eval(scriptMIN);
            String scriptROUND = "function ROUND(VAL1,DIGITS){ return VAL1.toFixed(DIGITS);}";
            engine.eval(scriptROUND);
            String scriptIF = "function IF(COND,VAL1,VAL2){ return COND?VAL1:VAL2;}";
            engine.eval(scriptIF);
            String scriptABS = "function ABS(VAL1){return Math.abs(VAL1)}";
            engine.eval(scriptABS);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void eval(String script) {
        try {
            System.out.println(engine.eval(script));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
