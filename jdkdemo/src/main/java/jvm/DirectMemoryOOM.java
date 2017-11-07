package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午5:19
 * Blog: coderdaily.net
 * <p>
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unSafeField = Unsafe.class.getDeclaredFields()[0];
        unSafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unSafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
