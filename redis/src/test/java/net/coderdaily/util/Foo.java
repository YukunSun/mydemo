package net.coderdaily.util;

import java.io.Serializable;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/5 下午10:12
 * Blog: coderdaily.net
 * <p>
 * 用于测试的类
 */
public class Foo implements Serializable {
    private Long id;
    private String name;
    private Integer age;

    public Foo() {
    }

    public Foo(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
