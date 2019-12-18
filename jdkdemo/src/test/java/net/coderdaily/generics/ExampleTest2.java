package net.coderdaily.generics;

import net.coderdaily.jdk8.util.User;
import org.junit.Test;

import java.util.*;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/15 23:03
 * Blog: coderdaily.net
 * <p>
 * 演示：用在方法上
 */
public class ExampleTest2 {


    /**
     * 你说气不气人，啥都能接收😄
     */
    @Test
    public void genericTest1() {
        GenericMethods methods = new GenericMethods();
        methods.f("hello");
        methods.f(2);
        methods.f(2.3);
        methods.f('a');
        methods.f(methods);
    }

    @Test
    public void test2() {
        Map<String, Integer> map = New.map();
        System.out.println("map = " + map);
        List<String> list = New.list();
        System.out.println("list = " + list);

        //FIXME：与书不一样，java8改进了？
        New.fun(New.map());
        New.<User, List<Test>>fun(New.map());
    }

    @Test
    public void generatorsTest() {
        Collection<Coffee> coffees = Generators.fill(new ArrayList<Coffee>(), new CoffeeGenerator<>(), 4);
        System.out.println("coffees = " + coffees);

        Collection<Integer> numbers = Generators.fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        System.out.println("numbers = " + numbers);
    }

    @Test
    public void test4() {
        for (int i = 0; i < 5; i++) {
            Generator<CountedObject> generator = BasicGenerator.create(CountedObject.class);
            System.out.println("CountedObject = " + generator.next());
        }
    }
}

class CountedObject {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return "CountedObject{" +
                "id=" + id +
                '}';
    }
}

class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
}


class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    static void fun(Map<User, List<? extends Test>> map) {
        System.out.println("map = " + map);
    }
}


class GenericMethods {
    public <T> void f(T t) {
        System.out.println("t = " + t);
    }
}