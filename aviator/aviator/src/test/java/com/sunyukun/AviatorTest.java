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

    public void testMap() {
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // Execute with injected variables.
        Boolean result = (Boolean) compiledExp.execute(compiledExp.newEnv("a", 100.3, "b", 45, "c", -199.100));
        System.out.println(result);
    }

    public void testValidate() {
        AviatorEvaluator.validate("1 +* 2");
    }


    
    public void testName() {
        //todo 引擎模式：https://www.yuque.com/boyan-avfmj/aviatorscript/fycwgt
        //todo 最佳实践：https://www.yuque.com/boyan-avfmj/aviatorscript/ou23gy
    }
}
