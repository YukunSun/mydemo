package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午12:18
 * Blog: coderdaily.net
 * <p>
 * -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
