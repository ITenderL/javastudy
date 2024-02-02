package com.itender;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author yuanhewei
 * @date 2024/2/1 14:58
 * @description
 */
public class Teat {
    public static void main(String[] args) throws ScriptException {
        String str = "1+(2-3/4)*5";
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(scriptEngine.eval(str));
    }
}
