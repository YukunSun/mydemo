package spring;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/7 下午9:12
 * Blog: coderdaily.net
 */
public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void selectTheUser() {
        System.out.println("the user's name：" + name);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
