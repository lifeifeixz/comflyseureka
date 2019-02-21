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

import java.lang.reflect.Proxy;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/11/22 17:02
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Class<?> mapperInterface = Subject.class;
        Class<?>[] interfaces = new Class[1];
        interfaces[0] = Subject.class;
        Subject realSubject = (Subject) Proxy.newProxyInstance(mapperInterface.getClassLoader()
                , interfaces, new DynamicProxy());

        System.out.println(realSubject.replaceString("李飞飞"));


    }
}

@SuppressWarnings("all")
class Test2 {
    public static void main(String[] args) {
            Class<?> loader = Car.class;
        Class<?>[] interfaces = new Class[1];
        interfaces[0] = loader;
        Car malibu = (Car) Proxy.newProxyInstance(loader.getClassLoader()
                , interfaces, new DynamicProxy(new Malibu()));

        malibu.run(120);
    }
}
