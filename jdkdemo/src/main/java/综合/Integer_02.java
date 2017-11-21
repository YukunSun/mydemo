package 综合;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/16 下午9:55
 * Blog: coderdaily.net
 */
public class Integer_02 {
    public static void main(String[] args) {
        Integer_02 obj = new Integer_02();
        int i = 140;
//        i自动由int 转成 long,所以调用f(long i)
        obj.f(i);
//i转成了Integer类型，发现没有f(Integer i)，所以只能又转回f(int i)，然后自动拓宽为long，调用f(long i)
        obj.f(Integer.valueOf(i));//从而也说明了这一步是没必要转的，Integer.valueOf(i)


//        编译不通过，int不能直接拓宽为Long,可以通过(long) i拓宽成long，然后包装成Long
//        obj.f3(i);
        obj.f3((long) i);
    }

    private void f(long i) {
        System.out.println("f-1");
    }

    private void f(Long i) {
        System.out.println("f-2");
    }

    private void f3(Long i) {
    }
}
