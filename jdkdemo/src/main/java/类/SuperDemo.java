package 类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/10/12 下午9:34
 * Blog: coderdaily.net
 */
public class SuperDemo {
    public static void main(String[] args) {
        new Son();//1，将进入子类构造器
    }
}

class Father {
    public int num = 2;//3

    public Father() {
        System.out.println("Father Constructor start:" + this.num);//获取并打印3处的值
        getNum();//4，执行到此处时，因为该方法已经被子类覆盖，所以执行了5处的方法
        System.out.println("Father Constructor end:" + this.num);
    }

    public void getNum() {
        System.out.println("Father getNum():" + this.num);//8
    }
}

class Son extends Father {
    public int num = 4;//6

    public Son() {
        //Son Constructor start...（super必须放到第一行）
        super();//2，将会调父类的构造器
        super.getNum();//7
        System.out.println("Son Constructor end:" + num);//9
    }

    public void getNum() {
        System.out.println("Son getNum():" + num);//5,此时的num还是编译期的值0
    }
}