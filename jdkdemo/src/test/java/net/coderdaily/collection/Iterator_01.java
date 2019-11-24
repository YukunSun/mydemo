package net.coderdaily.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/15 下午11:10
 * Blog: coderdaily.net
 */
public class Iterator_01<T> extends ArrayList<T> {
    public Iterator_01(Collection<? extends T> c) {
        super(c);
    }


    public Iterable<T> reversed() {
        Iterable<T> obj = new Iterable<T>() {
            public Iterator<T> iterator() {
                final int[] current = {size() - 1};
                return new Iterator<T>() {
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    public boolean hasNext() {
                        return current[0] > -1;
                    }

                    public T next() {
                        return get(current[0]--);
                    }
                };
            }
        };
        return obj;
    }

    public static void main(String[] args) {
        Iterator_01<String> ite = new Iterator_01(Arrays.asList("helllo world java".split(" ")));
        for (String s : ite) {
            System.out.println(s + " ");
        }
        for (String s : ite.reversed()) {
            System.out.println(s + " ");
        }
    }

}
