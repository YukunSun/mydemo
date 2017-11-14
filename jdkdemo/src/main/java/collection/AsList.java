package collection;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/9 下午10:53
 * Blog: coderdaily.net
 */
public class AsList {

    public static void main(String[] args) {
        List<GP> list = asList(new P1(), new P2(), new P3());

//        Error:(16, 39) java: 不兼容的类型: java.util.List<collection.AsList.P1>无法转换为java.util.List<collection.AsList.GP>
//        List<GP> list2 = Arrays.asList(new C1(),new C2());

//        “显示类型参数说明”-- 直接去说明实际的类型是什么
        List<GP> list3 = Arrays.<GP>asList(new C1(), new C2());
    }

    static class GP {
    }

    static class P1 extends GP {
    }

    static class P2 extends GP {
    }

    static class P3 extends GP {
    }

    static class C1 extends P1 {
    }

    static class C2 extends P1 {
    }
}
