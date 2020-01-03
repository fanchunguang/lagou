package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/26 19:43
 **/
public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream in) throws DocumentException {
        Document document = new SAXReader().read(in);
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");

        List<Element> list = rootElement.selectNodes("//select");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sql = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParamterType(parameterType);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);

            String key = namespace +"." + id;
            this.configuration.getMappedStatementMap().put(key, mappedStatement);
        }

        this.deleteParse(namespace, rootElement);
        this.insertParse(namespace, rootElement);
        this.updateParse(namespace, rootElement);
    }

    /**
     * 解析insert
     * @param namespace
     * @param rootElement
     */
    private void insertParse(String namespace,Element rootElement){
        List<Element> insertList = rootElement.selectNodes("//insert");
        for (Element element : insertList) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sql = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParamterType(parameterType);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);

            String key = namespace +"." + id;
            this.configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }

    /**
     * 解析delete
     * @param namespace
     * @param rootElement
     */
    private void deleteParse(String namespace,Element rootElement){
        List<Element> deleteList = rootElement.selectNodes("//delete");
        for (Element element : deleteList) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sql = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParamterType(parameterType);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);

            String key = namespace +"." + id;
            this.configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }

    /**
     * 解析update
     * @param namespace
     * @param rootElement
     */
    private void updateParse(String namespace,Element rootElement){
        List<Element> updateList = rootElement.selectNodes("//update");
        for (Element element : updateList) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sql = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParamterType(parameterType);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);

            String key = namespace +"." + id;
            this.configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }
}
