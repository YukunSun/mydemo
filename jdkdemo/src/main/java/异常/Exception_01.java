package 异常;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/1 下午4:47
 * Blog: coderdaily.net
 */
public class Exception_01 extends Exception {
    private List<Throwable> causes = new ArrayList<Throwable>();

    public Exception_01(List<? extends Throwable> cause) {
        causes.addAll(cause);
    }

    public List<Throwable> getExceptions() {
        return causes;
    }


}

class Demo {
    public void doSth() throws Exception_01 {
        List<Throwable> exptions = new ArrayList<Throwable>();
        try {
            throw new Exception("抛出exception 1");
        } catch (Exception e) {
            exptions.add(e);
        }

        try {
            throw new Exception("抛出exception 2");
        } catch (Exception e) {
            exptions.add(e);
        }
        if (exptions.size() > 0) {
            throw new Exception_01(exptions);
        }
    }

    public static void main(String[] args) throws Exception_01 {
        try {
            Demo demo = new Demo();
            demo.doSth();
        } catch (Exception_01 e) {
            System.out.println(e.getExceptions());
        }
    }
}
