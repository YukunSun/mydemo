package net.coderdaily.util;

import java.io.Serializable;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/5 下午10:12
 * Blog: coderdaily.net
 * <p>
 * 用于测试的类
 */
public class Foo implements Serializable{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
