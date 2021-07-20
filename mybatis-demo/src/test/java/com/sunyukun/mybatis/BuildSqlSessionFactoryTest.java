package com.sunyukun.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/20 08:31
 * Blog: sunyukun.com
 */
public class BuildSqlSessionFactoryTest {
    @Test
    void byXml() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object o = sqlSession.selectOne("selectBlog", 1);
        System.out.println("o = " + o);
    }
}
