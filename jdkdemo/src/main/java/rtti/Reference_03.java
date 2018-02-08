package rtti;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/25 下午10:39
 * Blog: coderdaily.net
 */
public class Reference_03 {


    public static void change(P p) {
        p.x = p.x + p.y;
        p.y = p.x - p.y;
        p.x = p.x - p.y;
    }



    public static void main(String[] args) {
        P p = new P();
        p.x = 3;
        p.y = 4;
        change(p);
        System.out.println(p.x + "----" + p.y);//输出4----3

    }
}

class P {
    int x;
    int y;
}