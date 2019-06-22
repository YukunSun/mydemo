package designpattern.strategy;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 14:11
 * Blog: coderdaily.net
 */
public class OperationMultiply implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
