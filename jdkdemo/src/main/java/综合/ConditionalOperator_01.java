package 综合;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2017/12/5 上午9:42
 * Blog: coderdaily.net
 * <p>
 * 三目运算符
 */
public class ConditionalOperator_01 {
    public static void main(String[] args) {
        Object o_31 = false ? 'A' : (int) 65;
        Object o_32 = false ? (byte) 65 : (int) 65;
        Object o_33 = false ? (short) 65 : (int) 65;
        Object o_34 = false ? 'A' : (byte) 65;
        Object o_35 = false ? 'A' : (short) 65;
        Object o_36 = false ? (short) 65 : (long) 65;
        Object o_37 = false ? (int) 65 : (double) 65;
        Object o_38 = false ? 'A' : (int) 65535;
        Object o_39 = false ? 'A' : (int) 65536;
        System.out.println("o_31:   " + o_31.getClass());
        System.out.println("o_32:   " + o_32.getClass());
        System.out.println("o_33:   " + o_33.getClass());
        System.out.println("o_34:   " + o_34.getClass());
        System.out.println("o_35:   " + o_35.getClass());
        System.out.println("o_36:   " + o_36.getClass());
        System.out.println("o_37:   " + o_37.getClass());
        System.out.println("o_38:   " + o_38.getClass());
        System.out.println("o_39:   " + o_39.getClass());
    }
}
