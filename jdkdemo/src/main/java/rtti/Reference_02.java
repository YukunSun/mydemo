package rtti;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/25 下午10:33
 * Blog: coderdaily.net
 */
public class Reference_02 {
    public static void change(int x, int y) {
        x = x + y;
        x = x - y;
        y = x - y;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        change(x, y);
        System.out.println(x + "----" + y);//输出3----4
    }
}
