package 综合;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/21 下午9:55
 * Blog: coderdaily.net
 */
public class String_05 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(i);
        }
        System.out.println(builder.toString());
    }
}
