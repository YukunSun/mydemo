package net.coderdaily.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/11/23 22:44
 * Blog: coderdaily.net
 */
public class IteratorTest {
    /**
     * ListIterator
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
}
