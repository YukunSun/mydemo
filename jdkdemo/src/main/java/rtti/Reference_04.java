package rtti;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/25 下午11:06
 * Blog: coderdaily.net
 */
public class Reference_04 {
    public static void change(int x, int y) {
        x = x + y;
        x = x - y;
        y = x - y;
    }

    public static void main(String[] args) {
        P p = new P();
        p.x = 3;
        p.y = 4;
        change(p.x, p.y);
        System.out.println(p.x + "----" + p.y);//输出3---4
    }
}
