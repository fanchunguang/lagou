package com.lagou.sqlSession;

import java.util.List;

public interface SqlSession {
    //查询所有
    public <E> List<E> selectList(String statementid,Object ...param) throws Exception;
    //查询单个
    public <T> T selectOne(String statementid,Object ...param) throws Exception;
    //插入
    public int insert(String statementId,Object ...param) throws Exception;
    //更新
    public int update(String statementId,Object ...param) throws Exception;
    //删除
    public int delete(String statementId,Object ...param) throws Exception;
}
