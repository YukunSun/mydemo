package net.coderdaily.generics;

import org.junit.Test;

import java.util.*;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/26 23:12
 * Blog: coderdaily.net
 * <p>
 * 擦除
 */
public class ExampleTest6 {
    @Test
    public void test1() {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1);//class java.util.ArrayList
        System.out.println("c1 == c2 = " + (c1 == c2));//true
    }

    /**
     * 通过输出内容可以观察到：只剩占位符了，相关的参数信息却没有......
     */
    @Test
    public void test2() {
        class Frob {
        }

        class Fnorkle {
        }
        class Quark<Q> {
        }
        class Paricle<POSITION, MOMENTUM> {
        }

        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Paricle<Long, Double> paricle = new Paricle<>();
        //查看类型参数
        System.out.println("Arrays.toString(list.getClass().getTypeParameters()) = " + Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println("Arrays.toString(map.getClass().getTypeParameters()) = " + Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println("Arrays.toString(quark.getClass().getTypeParameters()) = " + Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println("Arrays.toString(paricle.getClass().getTypeParameters()) = " + Arrays.toString(paricle.getClass().getTypeParameters()));
        //output:
        // Arrays.toString(list.getClass().getTypeParameters()) = [E]
        //Arrays.toString(map.getClass().getTypeParameters()) = [K, V]
        //Arrays.toString(quark.getClass().getTypeParameters()) = [Q]
        //Arrays.toString(paricle.getClass().getTypeParameters()) = [POSITION, MOMENTUM]
    }
}
