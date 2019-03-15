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
package learn.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author flysLi
 */
public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        for(int k=0;k<10;k++){
            Thread[] threads = new Thread[THREADS_CONUT];
            for (int i = 0; i < THREADS_CONUT; i++) {
                threads[i] = new Thread(() -> {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        increase();
                    }
                });
                threads[i].start();
            }

            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
            System.out.println(count);
        }
    }
}