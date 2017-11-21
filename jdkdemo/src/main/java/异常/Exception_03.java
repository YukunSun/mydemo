package 异常;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/2 下午1:51
 * Blog: coderdaily.net
 */
public class Exception_03 {
    public Exception_03(Integer value) {
        if (value < 18) {
            throw new RuntimeException("不能小于18");
        }
    }

    public void doSth()throws RuntimeException {
        System.out.println("do sth...");
    }

    public static void main(String[] args) {
        Exception_03 e1 = new Exception_03(19);
        e1.doSth();
        try {
            Exception_03 e2 = new Exception_03(10);
            e2.doSth();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
