package net.coderdaily.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/24 12:01
 * Blog: coderdaily.net
 */
public class SetTest {
    @Test
    public void test() {
        List<String> list = Arrays.asList("are", "best", "cat", "dog", "Bob");
        Set<String> words = new TreeSet<String>(list);
        //虽然是有序的，但是是按字典序排列的
        System.out.println("words = " + words);//words = [Bob, are, best, cat, dog]

        //按字母序排列
        Set<String> words2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words2.addAll(list);
        System.out.println("words2 = " + words2);//words2 = [are, best, Bob, cat, dog]
    }
}
