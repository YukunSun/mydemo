package net.coderdaily.generics;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    @Test
    public void methodDifference() {
        ContainerMethodDifferences cmd = new ContainerMethodDifferences();
        System.out.println("cmd.methodSet(Collection.class) = " + cmd.methodSet(Collection.class));
        System.out.println("cmd.interfaces(Collection.class) = " + cmd.interfaces(Collection.class));

        System.out.println("cmd.object = " + cmd.object);

        cmd.difference(Set.class, Collection.class);
        cmd.difference(HashSet.class, Set.class);
    }
}


class ContainerMethodDifferences {
    public static Set<String> methodSet(Class<?> type) {
        Set<String> result = new HashSet<>();
        Arrays.stream(type.getMethods()).map(m -> result.add(m.getName())).collect(Collectors.toSet());
        return result;
    }

    public static Set<String> interfaces(Class<?> type) {
        Set<String> result = new HashSet<>();
        Arrays.stream(type.getInterfaces()).map(m -> result.add(m.getSimpleName())).collect(Collectors.toSet());
        return result;
    }

    static Set<String> object = methodSet(Object.class);

    static {
        //native method
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        Set<String> diff = Sets.difference(methodSet(superset), methodSet(subset));
        diff.removeAll(object);
        System.out.println("diff = " + diff);
        System.out.println("interfaces(superset) = " + interfaces(superset));
    }
}

enum Letters {
    C, B, A, E, F, D, G, I, J, H, L, K, P, O, M, N, T, S, Q, R, V, U, X, Z, Y, W
}