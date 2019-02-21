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
 * @ClassName Hello
 * @Decription TODO
 * @Date 2018/11/23 14:25
 * @Version 1.0
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String str) {
        System.out.println("hello " + str);
    }
}
