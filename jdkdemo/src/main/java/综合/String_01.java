package 综合;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/1 下午12:01
 * Blog: coderdaily.net
 */
public class String_01 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = str1.intern();
        String str3 = "hello".intern();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        String str4 = "hello2".intern();
        System.out.println(str4);
    }
}
