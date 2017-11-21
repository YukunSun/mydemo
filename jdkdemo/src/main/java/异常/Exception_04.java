package 异常;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/2 下午3:06
 * Blog: coderdaily.net
 * <p>
 * 使用Throwable类获取栈信息
 */
public class Exception_04 {
    public static boolean doSth() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        for (StackTraceElement i :
                stackTraceElements) {
            if ("m1".equals(i.getMethodName())) {
                return true;
            }
        }
        throw new RuntimeException("除m1方法外，不允许别的方法调用...");
    }


    static class Invoker {
        public void m1() {
            System.out.println("m1:" + Exception_04.doSth());
        }

        public void m2() {
            System.out.println("m2：" + Exception_04.doSth());
        }
    }

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.m1();
        invoker.m2();
    }
}
