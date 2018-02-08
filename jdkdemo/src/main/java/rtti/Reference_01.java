package rtti;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/25 下午10:25
 * Blog: coderdaily.net
 */
public class Reference_01 {
    public static void main(String[] args) {
        Long a = 1L;
        int b = 1;
        R r = new R();
        r.v = 3;
        f(a, b, r);


        System.out.println(a);
        System.out.println(b);
        System.out.println(r.v);
    }

    private static void f(Long a, int b, R r) {
        a = 2L;
        b = 2;
        r.v = 2;
    }

}

class R {
    int v;
}
