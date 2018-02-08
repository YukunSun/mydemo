package 综合;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2017/12/23 上午8:13
 * Blog: coderdaily.net
 */
public class CodeBlock_01 {

    public CodeBlock_01() {
        System.out.println("无参构造函数");
    }

    {
        System.out.println("普通代码块");
    }

    public static void main(String[] args) {
        CodeBlock_01 obj = new CodeBlock_01();
    }
}
