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

import learn.degisn.fbatis.executor.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author flysLi
 * @ClassName MapperDynamicProxy
 * @Decription TODO
 * @Date 2018/11/23 15:43
 * @Version 1.0
 */
public class MapperDynamicProxy implements InvocationHandler {

    private Configuration configuration;

    private Executor executor;

    public MapperDynamicProxy(Configuration configuration) {
        this.configuration = configuration;
        this.executor = null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " 方法");
        return args[0];
    }
}
