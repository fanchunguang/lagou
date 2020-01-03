package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/26 19:28
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
