package designpattern.chainofresponsibility;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 15:22
 * Blog: coderdaily.net
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Logger:" + message);
    }
}
