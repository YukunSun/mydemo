package net.coderdaily.spring.aop.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/21 11:40
 * Blog: bengle.me
 */
public class UserDaoProxy implements InvocationHandler {
    private Object object;

    public UserDaoProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke,methodName:" + method.getName() + ",args:" + Arrays.toString(args));

        Object result = method.invoke(object, args);

        System.out.println("after invoke,result:" + result);
        return result;
    }

    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDaoProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoImpl));

        int result = userDao.add(2, 5);
        System.out.println("result = " + result);

        System.out.println("==========================");

        int result2 = userDao.update();
        System.out.println("result2 = " + result2);
    }
}
