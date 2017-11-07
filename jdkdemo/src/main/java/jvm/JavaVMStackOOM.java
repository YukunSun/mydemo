package jvm;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午4:28
 * Blog: coderdaily.net
 * <p>
 * -Xss160K
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
