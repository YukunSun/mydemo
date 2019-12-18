package net.coderdaily.generics;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/18 23:36
 * Blog: coderdaily.net
 */
public class ExampleTest3 {
    @Test
    public void setsTest() {
        Set<Letters> s1 = EnumSet.range(Letters.C, Letters.M);
        System.out.println("s1 = " + s1);
        Set<Letters> s2 = EnumSet.range(Letters.K, Letters.W);
        System.out.println("s2 = " + s2);
        System.out.println("Sets.intersection(s1,s2) = " + Sets.intersection(s1, s2));
        System.out.println("Sets.difference(s1,s2) = " + Sets.difference(s1, s2));
        System.out.println("Sets.union(s1,s2) = " + Sets.union(s1, s2));
        System.out.println("Sets.complement(s1,s2) = " + Sets.complement(s1, s2));
    }
}

enum Letters {
    C, B, A, E, F, D, G, I, J, H, L, K, P, O, M, N, T, S, Q, R, V, U, X, Z, Y, W
}