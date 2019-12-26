package net.coderdaily.generics;

import net.coderdaily.util.Generator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/12 08:13
 * Blog: coderdaily.net
 * <p>
 * 这些都是泛型的演示:用在类上
 */
public class ExampleTest {

    @Test
    public void fibonacciTest() {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println("fibonacci = " + fibonacci.next());
        }
        //加一个 iterable 的功能
        for (int i : new IterableFibonacci(10)) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 随机生成一个 Coffee 类型的对象
     */
    @Test
    public void generatorTest() throws InstantiationException, IllegalAccessException {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println("generator = " + generator.next());
        }
        for (Object coffee : new CoffeeGenerator(5)) {
            System.out.println("coffee = " + coffee);
        }
    }

    @Test
    public void stackTest() {
        LinkedStack<String> stack = new LinkedStack<>();
        for (String s : "hello world foo bar".split(" ")) {
            stack.push(s);
        }
        String s;
        while ((s = stack.pop()) != null) {
            System.out.println("s = " + s);
            //s = bar
            //s = foo
            //s = world
            //s = hello
        }
    }

    /**
     * 实现一个随机取数据的 List
     */
    @Test
    public void randomListTest() {
        RandomList<String> list = new RandomList<>();
        for (String i : "hello world foo bar".split(" ")) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("list.select() = " + list.select());
        }
    }
}

class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }
}

class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {

        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }
}


class CoffeeGenerator<Coffee> implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class};
    private static Random random = new Random(30);
    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public CoffeeGenerator() {
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }
}

class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {
}

class Mocha extends Coffee {
}

class Cappuccino extends Coffee {
}

class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
}


/**
 * custom stack
 *
 * @param <T>
 */
class LinkedStack<T> {
    private static class Node<T> {
        T item;
        Node<T> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();//end sentinel

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {//不断判断
            top = top.next;
        }
        return result;
    }
}
