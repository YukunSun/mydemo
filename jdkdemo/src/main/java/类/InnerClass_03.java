package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/22 上午9:34
 * Blog: coderdaily.net
 */
public interface InnerClass_03 {
    void f();

    class Test implements InnerClass_03 {
        public void f() {
            System.out.println("inner.....");
        }

        public static void main(String[] args) {
            new Test().f();
        }
    }
}
