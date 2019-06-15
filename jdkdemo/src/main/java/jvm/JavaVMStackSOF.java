package jvm;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午4:21
 * Blog: coderdaily.net
 * <p>
 * -Xss160k
 */
public class JavaVMStackSOF {
    private static int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF stackSOF = new JavaVMStackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈的深度：" + stackLength);
            throw e;
        }
    }
}
