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
package thread.deallock;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/25 16:05
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        Object o1=new Object();
        Object o2=new Object();
        Thread t1 = new Thread(new DealLock(false,o1,o2));

        Thread t2 = new Thread(new DealLock(true,o1,o2));
        t1.start();
        t2.start();
    }
}
