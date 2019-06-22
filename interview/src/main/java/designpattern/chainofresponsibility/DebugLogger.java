package designpattern.chainofresponsibility;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 15:19
 * Blog: coderdaily.net
 */
public class DebugLogger extends AbstractLogger {
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug Logger:" + message);
    }
}
