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
 * @ClassName DealLock
 * @Decription TODO
 * @Date 2018/10/25 16:00
 * @Version 1.0
 */
public class DealLock implements Runnable {
    boolean falg;

    public DealLock(boolean falg,Object o1,Object O2) {
        this.falg = falg;
        this.obj1 = o1;
        this.obj2 = O2;
    }

    Object obj1;
    Object obj2;

    @Override
    public void run() {
        if (falg) {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() + " hava o1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + " hava o2");
                }
            }
        } else {
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + " java o2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + " java o1");
                }
            }

        }
    }
}
