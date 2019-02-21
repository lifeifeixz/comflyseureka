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

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author flysLi
 * @ClassName ExecutorsPoolDemo
 * @Decription TODO
 * @Date 2018/12/7 10:31
 * @Version 1.0
 */
public class ExecutorsPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,
                8,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(8),
                new RejectedDefault());
        Runnable runnable = new TicketPurchase();
        for (int i=0;i<20;i++){
            poolExecutor.execute(runnable);
        }
        System.out.println("任务分配完毕!");
        poolExecutor.shutdown();
    }
}
