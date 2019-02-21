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
package learn.degisn.aop;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/11/23 14:29
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
        hello.sayHello("today");
    }
}
