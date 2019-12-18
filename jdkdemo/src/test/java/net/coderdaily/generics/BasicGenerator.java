package net.coderdaily.generics;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/18 22:56
 * Blog: coderdaily.net
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
