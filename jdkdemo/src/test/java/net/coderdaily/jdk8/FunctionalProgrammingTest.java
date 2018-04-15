package net.coderdaily.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/4/15 上午11:57
 * Blog: coderdaily.net
 * <p>
 * 函数式编程
 */
public class FunctionalProgrammingTest {
    /**
     * 理解注解 @FunctionalInterface
     */
    @FunctionalInterface
    public interface IntHandler {
        //        只能有一个抽象方法
        void handler(int i);

        //        java.lang.Object中的方法算作“实例方法”
        boolean equals(Object o);
    }

    /**
     * 理解lambda表达式： ->
     */
    @Test
    public void f1() {
//        num必须声明为final，但是如果不声明依然会编译通过，因为lambda表达式将使用的变量自动的视为final
        final int num = 2;

        Function<Integer, Integer> stringConverter = (from) -> from * num;
        System.out.println(stringConverter.apply(3));

//        与上边的代码完全等价
        Function<Integer, Integer> obj = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer from) {
                return from * num;
            }
        };
        System.out.println(obj.apply(3));
    }

    @Test
    public void f2() {
        String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));
    }

    /**
     * 理解方法引用符号 ::
     */
    @Test
    public void f3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(arr).map(x -> x + 1).forEach(System.out::println);
        System.out.println("---------");
//        ::表示调用一个实例方法
        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void f4() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("法一：");
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });

//        简化：省略接口名称
        System.out.println("法二：");
        Arrays.stream(arr).forEach((final int x) -> {
            System.out.println(x);
        });

//        进一步简化：因为for each 的参数是可以推导出来的，所以可以以此为契机，交给编译器去处理
        System.out.println("法三：");
        Arrays.stream(arr).forEach((x) -> {
            System.out.println(x);
        });

//        再借助方法引用符号更加简化：
        System.out.println("法四：");
        Arrays.stream(arr).forEach(System.out::println);
    }

}
