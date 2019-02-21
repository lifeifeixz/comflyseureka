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
package script.core.impl;

import script.core.MapperDynamicProxy;
import script.core.SqlSession;
import script.core.config.GlobalConfiguration;
import script.core.config.NameSpace;
import script.util.ClassUtil;
import script.util.Logger;
import script.util.PackageUtil;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author flysLi
 * @ClassName DefaultSqlSession
 * @Decription TODO
 * @Date 2018/12/17 14:31
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {
    private MapperDynamicProxy dynamicProxy;
    private GlobalConfiguration config;

    public DefaultSqlSession(String configPath) {
//        this.configPath = configPath;
        //读取配置文件后创建 GlobalConfiguration

        this(new GlobalConfiguration());
    }

    public DefaultSqlSession(GlobalConfiguration config) {
        this.config = config;
        this.init();
        this.dynamicProxy = new MapperDynamicProxy(config);
    }

    @Override
    public <T> T getMapper(Class<T> tClass) {
        ClassLoader classLoader = MapperDynamicProxy.class.getClassLoader();
        Class<?>[] classes = new Class[]{tClass};
        Object instance = Proxy.newProxyInstance(
                classLoader,
                classes,
                dynamicProxy);
        return (T) instance;
    }

    @Override
    public void init() {
        // TODO: 2018/12/18 读取配置文件

        // 建立nameSpace和mapperScript的关系
        Set<Class<?>> classes = PackageUtil.getClasses(config.getMapperPackage());
        Map<String, NameSpace> nameSpaceMap = new HashMap<>(1);
        for (Class<?> cls : classes) {
            NameSpace nameSpace = new NameSpace();
            Type[] actualType = ClassUtil.getActualTypesByClass(cls);
            if (actualType != null) {
                nameSpace.setGenericEntityType((Class<?>) actualType[0]);
                nameSpace.setGenericPrimaryKeyType((Class<?>) actualType[1]);
            } else {
                Logger.waring("在没有对Mapper进行泛型的情况下无法使用JPA功能:" + cls.getName());
            }
            nameSpaceMap.put(cls.getSimpleName().toUpperCase(), nameSpace);
        }
        this.config.setNameSpaceMap(nameSpaceMap);
    }

    public static void main(String[] args) throws IOException {
//        Type t = UserMapper.class.getGenericInterfaces()[0];
//        ParameterizedType parameterizedType = (ParameterizedType) t;
//        Type[] arguments = parameterizedType.getActualTypeArguments();
//        for (Type actualTypeArgument : arguments) {
//            System.out.println(actualTypeArgument);
//        }


    }
}
