package designpattern.strategy;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 14:12
 * Blog: coderdaily.net
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
