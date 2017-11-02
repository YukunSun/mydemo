package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/22 上午9:39
 * Blog: coderdaily.net
 */
public class InnerClass_04 {
    private void f0() {
        System.out.println("f0...");
    }

    class A {
        private void f1() {
            System.out.println("f1...");
        }

        public class B {
            void f2() {
                System.out.println("f2...");
                f1();
                f0();
            }
        }
    }

    public static void main(String[] args) {
        InnerClass_04 inner = new InnerClass_04();
        InnerClass_04.A innerA = inner.new A();
        InnerClass_04.A.B innerAB = innerA.new B();
        innerAB.f2();
    }
}
