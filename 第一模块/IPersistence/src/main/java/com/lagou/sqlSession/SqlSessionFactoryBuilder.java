package com.lagou.sqlSession;

import com.lagou.config.XMLConfigBuilder;
import com.lagou.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/26 6:53
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
        //1.解析配置文件，封装Configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new DefaultSqlSessionFactory(configuration);

        return sqlSessionFactory;
    }
}
