package net.coderdaily.generics;

import net.coderdaily.util.Generator;
import net.coderdaily.util.Generators;
import org.junit.Test;

import java.util.*;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/25 23:05
 * Blog: coderdaily.net
 * <p>
 * 应用到内部类、匿名内部类
 */
public class ExampleTest4 {
    @Test
    public void test1() {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);

        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);

        for (Customer customer : line) {
            serve(tellers.get(random.nextInt(tellers.size())), customer);
        }
    }

    public static void serve(Teller teller, Customer customer) {
        System.out.println(teller + " serve " + customer);
    }
}

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }

    public static Generator<Customer> generator() {
//        return new Generator<Customer>() {
//            @Override
//            public Customer next() {
//                return new Customer();
//            }
//        };
        //使用 lambda 表达式改写
        return () -> new Customer();
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    //更彻底的改写
//    public static Generator<Teller> generator = () -> new Teller();
    public static Generator<Teller> generator = Teller::new;
}