package jvm;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午5:01
 * Blog: coderdaily.net
 * <p>
 * 之所以输出不同的结果而是由于不同的虚拟机的版本intern的实现不一样，比如java_version = "1.8.0_144"中，“java”这个字符串已经在常量池中存在了，就不再放到常量池中了
 */
public class Intern_01 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);//true

        /**
         * @see sun.misc.Version.launcher_name
         */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);//false
    }
}