package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/15 下午11:41
 * Blog: coderdaily.net
 */
public class Static_01 {
    static {
//        1.程序执行时会被加载
        System.out.println("static...程序启动时会被加载...");
    }

    public static void main(String[] args) {
//        2.不对B类进行初始化，因为可以在编译时得到值。
        System.out.println(B.test1);//执行此句不对类初始化。
//        3.对B进行初始化，因为编译时得不到该值。
        System.out.println(B.test2);//执行此句对类初始化
    }
}

//使用final修饰的static变量与类初始化的关系
class B {
    static {//如果没有初始化将不被打印
        System.out.println("静态初始化块。。。//被初始化时打印");
    }

    static final String test1 = "如果一个静态属性使用final修饰，如果它的值可以在编译时得到，系统会认为该类被被动使用，将不会对该类进行初始化";
    static final String test2 = System.currentTimeMillis() + "";
}
