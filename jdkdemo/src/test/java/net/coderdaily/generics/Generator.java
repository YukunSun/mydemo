package net.coderdaily.generics;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/12 23:18
 * Blog: coderdaily.net
 * <p>
 * 用来创建对象
 */
public interface Generator<T> {
    /**
     * 调用该方法生成对象
     *
     * @return
     */
    T next();
}
