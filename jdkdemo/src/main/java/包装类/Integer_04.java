package 包装类;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2017/12/23 上午8:24
 * Blog: coderdaily.net
 */
public class Integer_04 {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a == b);//false
        System.out.println(a > b);//false
        System.out.println(a >= b);//true
        System.out.println(a < b);
        System.out.println(a <= b);
    }
}
