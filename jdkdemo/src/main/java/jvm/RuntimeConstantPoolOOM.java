package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午4:38
 * Blog: coderdaily.net
 * <p>
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
