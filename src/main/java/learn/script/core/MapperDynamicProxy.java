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
package script.core;

import script.common.annotations.Drop;
import script.common.annotations.NameSpace;
import script.core.config.GlobalConfiguration;
import script.core.impl.DefaultExecutor;
import script.core.impl.DefaultResultHandler;
import script.core.impl.DefaultSqlAnalysis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author flysLi
 * @ClassName MapperDynamicProxy
 * @Decription TODO
 * @Date 2018/12/17 14:13
 * @Version 1.0
 */
public class MapperDynamicProxy implements InvocationHandler {
    private Executor executor;
    private SqlAnalysis sqlAnalysis;

    public MapperDynamicProxy(GlobalConfiguration configuration) {
        executor = new DefaultExecutor(configuration);
        sqlAnalysis = new DefaultSqlAnalysis(configuration);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取命名空间
        NameSpace nameSpace = method.getDeclaringClass().getAnnotation(NameSpace.class);
        String mapperPath = nameSpace.path();
        Drop drop = method.getAnnotation(Drop.class);
        String dropType = null;
        if (drop != null) {
            dropType = drop.type();
        }
        Object param = args != null && args.length == 1 ? args[0] : args;
        String sql = sqlAnalysis.splitSql(mapperPath, method.getName(), param);
        Class<?> returnType = method.getReturnType();
        return executor.execute(sql, dropType, returnType);
    }
}
