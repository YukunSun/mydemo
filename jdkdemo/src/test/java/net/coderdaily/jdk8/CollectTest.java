package net.coderdaily.jdk8;

import net.coderdaily.jdk8.util.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/3/2 22:46
 * Blog: coderdaily.net
 */
public class CollectTest {
    Stream<User> stream = Stream.of(
            new User("foo", 12),
            new User("bar", 8),
            new User("hello", 18)
    );

    /**
     * 转换为其他的集合
     */
    @Test
    public void toOtherCollection() {
        //为避免java.lang.IllegalStateException: stream has already been operated upon or closed
        Supplier<Stream<User>> supplier = () -> Stream.of(
                new User("foo", 12),
                new User("bar", 8),
                new User("hello", 18)
        );
        Set<User> set = supplier.get().collect(Collectors.toCollection(HashSet::new));
        assert set.size() == 3;

        List<User> list = supplier.get().collect(Collectors.toCollection(ArrayList::new));
        assert list.size() == 3;
    }

    @Test
    public void toValue() {
        Optional<User> max = stream.collect(Collectors.maxBy(Comparator.comparing(User::getAge)));
        assert max.get().getName().equals("hello");
    }
}
