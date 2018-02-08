package 类;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/1/31 下午8:24
 * Blog: coderdaily.net
 * <p>
 * 对象的浅拷贝，shadow clone
 */
public class Clone_01 implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clone_01(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Clone_01 obj1 = new Clone_01("obj1");

        Clone_01 obj2 = (Clone_01) obj1.clone();
        System.out.println(obj1 + ":" + obj1.getName());
        System.out.println(obj2 + ":" + obj2.getName());

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1 == obj2);
        System.out.println(obj1.getClass() == obj2.getClass());
    }
}