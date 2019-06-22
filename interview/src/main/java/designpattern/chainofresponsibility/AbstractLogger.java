package designpattern.chainofresponsibility;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 15:11
 * Blog: coderdaily.net
 */
public abstract class AbstractLogger {
    /**
     * 设置成数字形式，便于比较大小
     */
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    /**
     * 传递给子类，以便构造对象
     */
    protected int level;
    /**
     * 整个责任链中的下一个元素
     */
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    /**
     * 为了复用同样的逻辑
     *
     * @param level
     * @param message
     */
    public void logMessage(int level, String message) {
        //如果当前级别比较低的话，就不需要继续往下传了，直接在当前 Logger 里处理就行了
        if (this.level <= level) {
            write(message);
        }else if (nextLogger != null) {
            //交给下一个元素处理
            nextLogger.write(message);
        }
    }

    abstract protected void write(String message);
}
