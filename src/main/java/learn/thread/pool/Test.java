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
package thread.pool;

import java.util.concurrent.TimeUnit;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/25 17:40
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new DefaultThreadPool();
        for (int i = 0; i < 22; i++) {
            threadPool.execute(() -> {
                System.out.println("TASK product");
            });
            try {
                TimeUnit.MILLISECONDS.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(1L);
        threadPool.shutdown();
        System.out.println("shutdown : {" + threadPool.isShutdown() + "}");
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("停机后的任务提交");
            }
        });
        TimeUnit.SECONDS.sleep(1L);
        ((Thread) threadPool).start();
    }
}
