package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/22 上午8:44
 * Blog: coderdaily.net
 */
public class InnerClass_02 {
    private void f(boolean b) {
        if (b) {
            class A {
                private String id;

                A(String s) {
                    id = s;
                }

                String getId() {
                    return id;
                }
            }
            A a = new A("a......");
            String id = a.getId();
            System.out.println(id);
        }
        //在定义域之外是不可以用的
//        IOC_01 a = new IOC_01("b......");
    }

    public void test() {
        f(true);
    }

    public static void main(String[] args) {
        InnerClass_02 obj = new InnerClass_02();
        obj.test();
    }
}
