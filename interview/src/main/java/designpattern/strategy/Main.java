package designpattern.strategy;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-22 14:14
 * Blog: coderdaily.net
 */
public class Main {
    public static void main(String[] args) {
        //创建一个 OperationAdd 对象，传给 Context，我们并没有去执行 OperationAdd.doOperation 方法
        OperationAdd add = new OperationAdd();
        Context context = new Context(add);
        System.out.println(context.executeStrategy(2, 3));

        //同理
        OperationMultiply multiply = new OperationMultiply();
        context = new Context(multiply);
        System.out.println(context.executeStrategy(2, 3));
    }
}
