package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/21 下午10:34
 * Blog: coderdaily.net
 */
public class InnerClass_01 {
    void f() {
        System.out.println("Out.f()....");
    }

    public class Inner {
        public InnerClass_01 outer() {
            return InnerClass_01.this;//本this指代Inner
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        InnerClass_01 outer = new InnerClass_01();
        InnerClass_01.Inner inner = outer.inner();
        inner.outer().f();

        InnerClass_01.Inner inner2 = outer.new Inner();
        inner.outer().f();
    }
}
