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
package thread.reentrant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author flysLi
 * @ClassName Warehouse
 * @Decription TODO
 * @Date 2018/10/23 16:56
 * @Version 1.0
 */
public class Warehouse implements Runnable {
    private Lock lock;

    public Warehouse(Lock lock) {
        init();
        this.lock = lock;
    }

    public List<String> books = new ArrayList<>(1000);

    public void init() {
        for (int i = 0; i < 1000; i++) {
            books.add(System.currentTimeMillis() + "-" + new Random(100000));
        }
    }

    public String fetch() {
        try {
            lock.lock();
            if (books.size() > 0) {
                return books.remove(books.size() - 1);
            } else {
                throw new RuntimeException("仓库已空");
            }
        } finally {
            lock.unlock();
        }


    }

    @Override
    public void run() {
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            try {
                arrayList.add(this.fetch());
                Thread.sleep(1);
            } catch (Exception e) {
                System.out.println("仓库已空");
                break;
            }
        }
        System.out.println("线程[" + Thread.currentThread() + "]\t收获:" + arrayList.size());
    }
}
