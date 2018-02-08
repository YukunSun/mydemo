package rtti;

import java.util.Arrays;
import java.util.List;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/25 下午10:15
 * Blog: coderdaily.net
 */
public abstract class Shape {
    void draw() {
        System.out.println(this);
    }

    abstract public String toString();

    public static void main(String[] args) {
        List<Shape> list = Arrays.asList(new Circle(), new Square());
        for (Shape i :
                list) {
            System.out.println(i);
            System.out.println(i.getClass());
        }
    }
}
