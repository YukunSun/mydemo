package net.coderdaily.spring.aop.proxy1;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/21 11:47
 * Blog: bengle.me
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(int i, int j) {
        System.out.println("执行了UserDaoImpl.add");
        return i + j;
    }

    @Override
    public int update() {
        return 0;
    }
}
