package com.lagou.pojo;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/25 23:50
 **/
public class MappedStatement {
    //id
    private String id;
    //sql语句
    private String sql;
    //结果类型
    private String resultType;
    //参数类型
    private String paramterType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParamterType() {
        return paramterType;
    }

    public void setParamterType(String paramterType) {
        this.paramterType = paramterType;
    }
}
