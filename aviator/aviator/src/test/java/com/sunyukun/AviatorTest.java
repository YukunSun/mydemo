package com.sunyukun;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import junit.framework.TestCase;

import java.io.IOException;

public class AviatorTest extends TestCase {
    AviatorEvaluatorInstance instance = AviatorEvaluator.getInstance();

    public void testCompileScript() throws IOException {
        for (int i = 0; i < 100; i++) {
            Expression exp = instance.compileScript("examples/hello.av");
            System.out.println("exp = " + exp);
            exp.execute();
        }
    }

    public void testCompileCache() throws IOException {
        for (int i = 0; i < 100; i++) {
            Expression exp = instance.compile("println('Hello, AviatorScript!');", true);
            System.out.println("exp = " + exp);
            exp.execute();
        }
    }
}
