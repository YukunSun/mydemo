package net.coderdaily.jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * Author: sunyukun@xueqiu.com
 * Time: 2018/5/14 下午2:36
 * Desc: 用于包装对象的一个类，兼容null对象
 */
public class OptionalTest {
    @Test
    public void optional() {
        Integer value1 = null;
        Integer value2 = 10;
//        可以包含null
        Optional<Integer> o1 = Optional.ofNullable(value1);
//        不可以包含null
        Optional<Integer> o2 = Optional.of(value2);

//       判断是否是null值，obj.isPresent() 等价于  value != null
        System.out.println("o1 is present:" + o1.isPresent());
        System.out.println("o2 is present:" + o2.isPresent() + ",o2.get():" + o2.get());

//        如果o1为null，则给一个默认值0
        System.out.println(o1.orElse(new Integer(0)));
    }
}
