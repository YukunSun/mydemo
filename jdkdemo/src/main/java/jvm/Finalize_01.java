package jvm;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/10 下午4:31
 * Blog: coderdaily.net
 */
public class Finalize_01 {
    public static Finalize_01 SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("alive...");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 正在执行...");

//        自救
        Finalize_01.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new Finalize_01();

//        首次自救
        SAVE_HOOK = null;
        System.gc();
//        finalize（）优先级很低，所以暂停1s
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead...");
        }

//        第二次自救失败
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead...");
        }
    }
}
