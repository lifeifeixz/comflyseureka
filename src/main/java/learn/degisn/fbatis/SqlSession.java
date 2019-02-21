/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package learn.degisn.fbatis;

import learn.degisn.fbatis.config.PropertiesLoader;
import learn.degisn.fbatis.config.ResourceLoader;
import learn.degisn.fbatis.mapper.DeptMapper;
import learn.degisn.fbatis.mapper.UserMapper;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author flysLi
 * @ClassName DefaultSqlSession
 * @Decription TODO
 * @Date 2018/11/23 15:27
 * @Version 1.0
 */
public class SqlSession {
    private Configuration configuration;

    private ResourceLoader resourceLoader = new PropertiesLoader();

    private Map<Class<?>, Object> mappers = new HashMap<>();

    public SqlSession(String resource) {
        this.configuration = resourceLoader.loadConfiguration(resource);
        // TODO: 2018/11/23 测试，固定包路径
        this.registerMapper(null);
    }

    protected void registerMapper(String packagePath) {
        Class<?> mapperInterface = DeptMapper.class;
        Class<?> mapperInterface2 = UserMapper.class;
        MapperDynamicProxy proxy = new MapperDynamicProxy(configuration);
        DeptMapper deptMapper = (DeptMapper) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class<?>[]{mapperInterface}, proxy);
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(mapperInterface2.getClassLoader(),
                new Class<?>[]{mapperInterface2}, proxy);
        mappers.put(mapperInterface, deptMapper);
        mappers.put(mapperInterface2, userMapper);
    }

    public <T> T getMapper(Class<T> tClass) {
        return (T) this.mappers.get(tClass);
    }

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession("src/main/resources/db.properties");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String name = userMapper.findNameById("12");
        System.out.println(name);
    }


}
