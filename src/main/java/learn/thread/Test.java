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
package thread;

import thread.lock.RedisLock;
import thread.reentrant.Warehouse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/9 9:42
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = null;
//        lock = new ReentrantLock(false);
        lock = new RedisLock();
        Warehouse warehouse = new Warehouse(lock);
        for (int i = 0; i < 5; i++) {
            new Thread(warehouse).start();

        }
    }
}
