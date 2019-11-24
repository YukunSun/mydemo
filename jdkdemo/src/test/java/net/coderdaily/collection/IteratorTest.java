package net.coderdaily.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/23 22:44
 * Blog: coderdaily.net
 */
public class IteratorTest {
    /**
     * ListIterator 实现双向遍历
     */
    @Test
    public void listIteratorTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //需要注明从哪儿开始，否则从0开始
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            Integer v = iterator.previous();
            System.out.println(v.intValue());
        }
    }

    /**
     * 使用哪种方式与容器解耦？
     */
    @Test
    public void interfaceVsIterator() {
        List<Integer> list = Arrays.asList(10, 6, 7, 9, 8, 3, 2, 4, 1, 5);
        display(list);

        display(list.iterator());
    }

    private static void display(Iterator<Integer> it) {
        while (it.hasNext()) {
            System.out.println("it.next() = " + it.next());
        }
    }

    private static void display(Collection<Integer> cols) {
        for (Integer i : cols) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 实现了 Iterable 接口的类都可以使用 foreach 来迭代
     */
    @Test
    public void custom() {
        for (String s : new IterableClass()) {
            System.out.println("s = " + s);
        }
    }
}

class IterableClass implements Iterable<String> {
    protected String[] words = ("hello world i am a crud boy").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }
}