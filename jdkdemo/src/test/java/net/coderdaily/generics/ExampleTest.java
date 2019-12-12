package net.coderdaily.generics;

import org.junit.Test;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/12 08:13
 * Blog: coderdaily.net
 */
public class ExampleTest {
    @Test
    public void test() {
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
}

/**
 * custom stack
 *
 * @param <T>
 */
class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
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
