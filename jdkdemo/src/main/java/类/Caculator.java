package 类;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/1/31 下午7:49
 * Blog: coderdaily.net
 * <p>
 * 匿名类调用的构造函数是与其参数匹配的
 */
public class Caculator {
    private int i, j, result;

    public Caculator(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Caculator() {
        System.out.println("c1...");
    }

    protected void setOperator(Ops operator) {
        result = operator.equals(Ops.ADD) ? i + j : i - j;
        System.out.println("c2...");
    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        Caculator c = new Caculator(1, 2) {
            {
                setOperator(Ops.ADD);
            }
        };
        System.out.println(c.getResult());
    }
}

enum Ops {ADD, SUB}