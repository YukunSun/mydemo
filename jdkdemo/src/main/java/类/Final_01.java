package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/15 下午9:40
 * Blog: coderdaily.net
 */
public class Final_01 {
    //    1. 修饰基本类型，表示不可被修改。
    public final int v1 = 1;
    //    2. 加上static,强调“只有一份”！
    public static final int v2 = 2;
    //    3. 可以不赋值，但是在构造器中必须赋值。
    public final int v3;

    //    4.也可修饰引用类型，意味着该指针不能再指向别的值。但是并不意味着值不可以改变！
    public final Value v4 = new Value(4);

    public Final_01() {
        v3 = 3;
    }

    void method(int v1, Value v2, final int v3, final Value v4) {
        v1 = 1;
        v2 = new Value(3);
        //5. 报错：正常参数可以被修改，但是被final修饰以后只能读，不能修改。
//        v3 = 10;
//        v4 = new Value(5);
    }

    class Value {
        int i;

        public Value(int i) {
            this.i = i;
        }

    }

    public static void main(String[] args) {
        Final_01 f = new Final_01();
        System.out.println(f.v4.i);
//        报错：不能再指向别的值。
//        f.v4 = new Value(5);
        f.v4.i = 2;
        System.out.println(f.v4.i);
    }
}
