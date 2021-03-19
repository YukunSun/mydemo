package net.coderdaily.spring.bean;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/20 00:43
 * Blog: bengle.me
 */
public class User {
    private String age;

    public User() {
        System.out.println("step1:执行无参构造函数");
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        System.out.println("step2:调用setter来设置值;age = " + age);
    }

    void initUser() {
        System.out.println("step3:初始化方法");
    }

    void destroyUser() {
        System.out.println("step5:销毁bean");
    }

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                '}';
    }
}
