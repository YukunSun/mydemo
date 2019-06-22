package designpattern.chainofresponsibility;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 15:24
 * Blog: coderdaily.net
 */
public class InfoLogger extends AbstractLogger {
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info Logger:" + message);
    }
}
