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
package learn.degisn.proxy;

import java.lang.reflect.Proxy;

/**
 * @author flysLi
 * @ClassName DynamicProxyDemo2
 * @Decription TODO
 * @Date 2018/12/10 16:27
 * @Version 1.0
 */
public class DynamicProxyDemo2 {
    public static void main(String[] args) {
        /**
         * ClassLoader loader,
         Class<?>[] interfaces,
         InvocationHandler h
         */

        BuyTicket buyTicket = (BuyTicket) Proxy.newProxyInstance(Cattle.class.getClassLoader(),
                new Class<?>[]{BuyTicket.class},
                new Cattle());
        buyTicket.buy(12.68);
    }
}
