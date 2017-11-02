package 综合;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/2 上午11:14
 * Blog: coderdaily.net
 */
public class Exception_02 {
    public static void main(String[] args) {
        int a = doSth();
        System.out.println(a);
    }

    private static int doSth() {
        int a = 0;
        try {
            int b = 1 / 0;
            return a;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a = 2;
            System.out.println("可以执行。。。");
        }
        return a;
    }
}
