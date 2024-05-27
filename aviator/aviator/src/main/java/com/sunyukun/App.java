package com.sunyukun;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        // Compile the script into a Expression instance.
        AviatorEvaluatorInstance instance = AviatorEvaluator.getInstance();
        System.out.println("instance = " + instance);
        Expression exp = instance.compileScript("examples/hello.av");
        // Run the exprssion.
        exp.execute();
    }
}
