package net.coderdaily.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/23 23:23
 * Blog: coderdaily.net
 */
public class LinkedListTest {
    LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    LinkedList<Integer> emptyList = new LinkedList<>();

    //移除
    @Test
    public void delTest() {
        list.removeFirst();
        list.remove(0);
        list.removeLast();
        System.out.println("list = " + list);

        //java.util.NoSuchElementException
//        emptyList.removeFirst();

        //如果为空，则返回 null，而非抛异常
        Integer v = emptyList.pollFirst();
        System.out.println(v);
    }

    //检查
    @Test
    public void lookupTest() {
        System.out.println(list.element());
        //java.util.NoSuchElementException
//        System.out.println(emptyList.element());

        //同理，如果为空，返回 null，而非抛异常
        System.out.println(emptyList.peek());
    }
}
