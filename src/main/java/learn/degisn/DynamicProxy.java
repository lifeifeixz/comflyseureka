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
package learn.degisn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author flysLi
 * @ClassName DynamicProxy
 * @Decription TODO
 * @Date 2018/11/22 17:00
 * @Version 1.0
 */
public class DynamicProxy implements InvocationHandler {

    private Malibu malibu;

    public DynamicProxy() {
    }

    public DynamicProxy(Malibu malibu) {
        this.malibu = malibu;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        malibu.getClass().getMethod(method.getName()).invoke(malibu, args[0]);
        return args[0];
    }

    public boolean extendsObject(Method method) {
        String name = method.getName();
        return false;
    }
}
