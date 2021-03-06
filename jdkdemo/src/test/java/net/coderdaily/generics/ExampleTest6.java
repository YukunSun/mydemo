package net.coderdaily.generics;

import org.junit.Test;

import java.lang.reflect.Array;
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
    public void testGenericErase() {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1);//class java.util.ArrayList
        System.out.println("c1 == c2 = " + (c1 == c2));//true
    }

    /**
     * 通过输出内容可以观察到：只剩占位符了，相关的参数信息却没有......
     */
    @Test
    public void testGenericErase2() {
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

    @Test
    public void test3() {
        ArrayMaker<String> stringMaker = new ArrayMaker(String.class);
        String[] array = stringMaker.create(9);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 即使这个类的内部关于 T 的信息被擦除了，但依然不会有任何报错
     */
    @Test
    public void test4() {
        ListMaker<String> stringListMaker = new ListMaker<>();
        stringListMaker.create();
    }

    @Test
    public void test5() {
        ClassTypeCapture<Building> capture = new ClassTypeCapture<>(Building.class);
        System.out.println(capture.f(new Building()));//true
        System.out.println(capture.f(new House()));//true

        ClassTypeCapture<House> capture2 = new ClassTypeCapture<>(House.class);
        System.out.println("capture2.f(new Building()) = " + capture2.f(new Building()));//false,Building 不可以强制转换为 House（父类不可强制转换为子类，除非父类是子类创建的）
        System.out.println("capture2.f(new House()) = " + capture2.f(new House()));//true
        System.out.println("(Building)new House() = " + (House) new Building());//java.lang.ClassCastException: net.coderdaily.generics.Building cannot be cast to net.coderdaily.generics.House
    }

    /**
     * isInstance demo
     */
    @Test
    public void testInstance() {
        System.out.println("new Building().getClass().isInstance(new House()) = " + new Building().getClass().isInstance(new House()));//true
        System.out.println("new House().getClass().isInstance(new Building()) = " + new House().getClass().isInstance(new Building()));//false
        System.out.println(new House() instanceof House);//true
        System.out.println(new Building() instanceof House);//false
        System.out.println(new House() instanceof Building);//true
    }

    /**
     * 工厂类:v1
     */
    @Test
    public void testFactory() {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("fe.x = " + fe.x);

        ClassAsFactory<Integer> fe2 = new ClassAsFactory<>(Integer.class);//throw exception:因为 Integer 没有默认的构造函数
        System.out.println("fe2.x = " + fe2.x);
    }

    /**
     * 工厂类：v2
     */
    @Test
    public void testFactory2() {
        System.out.println(" new Foo<Integer>(new IntegerFactory()) = " + new Foo<Integer>(new IntegerFactory()));
        System.out.println("new Foo<Widget>(new Widget.Factory()) = " + new Foo<Widget>(new Widget.Factory()));
    }

    /**
     * 模板方法的设计模式
     */
    @Test
    public void testTemplate() {
        Creator c = new Creator();
        System.out.println("c = " + c);
    }
}

abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        this.element = create();
    }

    protected abstract T create();
}

class Creator extends GenericWithCreate<Employee> {

    @Override
    protected Employee create() {
        return new Employee();
    }
}


class Building {
}

class House extends Building {
}

class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
}

class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }
}

class ListMaker<T> {
    List<T> create() {
        return new ArrayList<T>();
    }
}

/**
 * 擦除丢失了在泛型代码中执行某些操作的能力——在任何运行时需要知道的确切类型信息的操作都将无法工作。
 *
 * @param <T>
 */
class Erased<T> {
    private final int SIZE = 100;

    public static void f(Object arg) {
//        if (arg instanceof T){} //error
//        T var = new T();//error
//        T[] array = new T[SIZE];//error
//        T[] array2 = (T)new Object[SIZE];
    }
}

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
}

interface FactoryInterface<T> {
    T create();
}

class Foo<T> {
    private T x;

    public <F extends FactoryInterface<T>> Foo(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryInterface<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryInterface<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}