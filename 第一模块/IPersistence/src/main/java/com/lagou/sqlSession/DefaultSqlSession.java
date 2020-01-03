package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/26 20:42
 **/
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementid, Object... param) throws Exception{
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        List<Object> list =simpleExecutor.query(configuration, mappedStatement, param);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementid, Object... param) throws Exception{
        List<T> list =selectList(statementid,param);
        if(list.size()==1){
            return list.get(0);
        }else{
            throw new RuntimeException("查询结果为空或者返回多条");
        }
    }

    @Override
    public int insert(String statementId, Object... param) throws Exception {
        int i = this.update(statementId, param);
        return i;
    }

    @Override
    public int update(String statementId, Object... param) throws Exception {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        int i = simpleExecutor.update(configuration,mappedStatement,param);
        return i;
    }

    @Override
    public int delete(String statementId, Object... param) throws Exception {
        int i = this.update(statementId, param);
        return i;
    }
}
