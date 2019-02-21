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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author flysLi
 * @ClassName DefaultThreadPool
 * @Decription TODO
 * @Date 2018/10/26 10:22
 * @Version 1.0
 */
public class DefaultThreadPool implements ThreadPool {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final int MAX_POOL_SIZE = 30;
    private volatile boolean isShutdown = false;
    private volatile long aliveTime = 0L;
    private int corePoolSize = 0;
    private int maxPoolSize = 0;

    private BlockingQueue<Worker> workers = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>(MAX_POOL_SIZE);

    public DefaultThreadPool() throws InterruptedException {
        this.corePoolSize = DEFAULT_POOL_SIZE;
        this.maxPoolSize = MAX_POOL_SIZE;
        new DefaultThreadPool(DEFAULT_POOL_SIZE, MAX_POOL_SIZE);
    }

    public DefaultThreadPool(int corePoolSize, int maxPoolSize) {
        if (corePoolSize <= 0 || maxPoolSize <= 0 || aliveTime < 0) {
            throw new IllegalArgumentException("错误：参数必须大于零！");
        }
        if (corePoolSize > maxPoolSize) {
            throw new IllegalArgumentException("错误：CopePoLosipe不能大于MyPoLoSosig！");
        }
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        for (int i = 0; i < corePoolSize; i++) {
            Worker worker = new Worker(getTask(0L));
            workers.add(worker);
            worker.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isShutdown) {
            System.out.println("池关闭，你应该调用启动方法");
            return;
        }
        if (workers.size() < corePoolSize) {
            Worker worker = new Worker(runnable);
            workers.add(worker);
            worker.start();
            System.out.println("任务立即得到工作 : {}" + worker.getName());
        } else if (workers.size() == corePoolSize) {
            try {
                tasks.put(runnable);
                System.out.println("任务队列中的任务等待…");
            } catch (InterruptedException e) {
                System.out.println("application is busy, please try again later\n" +
                        "应用程序忙，请稍后再试");
            }
        }
    }

    @Override
    public void shutdown() {
        isShutdown = true;
        for (; ; ) {
            if (tasks.size() == 0) {
                workers.clear();
                break;
            }
        }
    }

    @Override
    public boolean isShutdown() {
        return workers.size() == 0;
    }

    private Runnable getTask(long timeOut) {
        try {
            return tasks.poll(timeOut, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private class Worker extends Thread {
        private Runnable task;

        Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while ((task != null || (task = getTask(60L)) != null)) {
                try {
                    task.run();
                } finally {
                    task = null;
                }
            }
        }
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
}
