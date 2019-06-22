package designpattern.chainofresponsibility;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 15:10
 * Blog: coderdaily.net
 * <p>
 * https://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 */
public class Main {
    /**
     * 相当于获得了一个链表，节点依次为：error -> info -> debug
     *
     * @return
     */
    public static AbstractLogger getLogger() {
        AbstractLogger debug = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger info = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger error = new InfoLogger(AbstractLogger.ERROR);

        error.setNextLogger(info);
        info.setNextLogger(debug);
        return error;
    }


    public static void main(String[] args) {
        //最核心的点，就是把各种处理给串起来，客户端并不清楚谁来处理当前的逻辑
        AbstractLogger logger = getLogger();

        logger.logMessage(AbstractLogger.DEBUG, "debug msg...");
        logger.logMessage(AbstractLogger.INFO, "info msg...");
        logger.logMessage(AbstractLogger.ERROR, "system error...");
    }
}
