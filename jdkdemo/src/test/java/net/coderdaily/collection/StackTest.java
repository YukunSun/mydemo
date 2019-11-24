package net.coderdaily.collection;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/24 11:22
 * Blog: coderdaily.net
 */
public class StackTest {
    @Test
    public void eg1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println("stack = " + stack);
        stack.push(3);
        stack.peek();
        System.out.println("stack = " + stack);
    }

    @Test
    public void eg2() {
        String str = "+U+n+c---+e+r+t---+a-+i-+n+t+y---++r+u--+l+e+s---";
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            char next = 0;
            if (i < arr.length - 1) {
                next = arr[i + 1];
            } else {
                continue;
            }
            if (current == '+') {
                stack.push(next);
            } else if (current == '-') {
                stack.pop();
            }
        }
        System.out.println("arr = " + stack);//arr = [+, l]
    }
}
