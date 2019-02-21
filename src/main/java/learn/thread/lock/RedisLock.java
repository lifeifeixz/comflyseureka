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
package thread.lock;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author flysLi
 * @ClassName RedisLock
 * @Decription TODO
 * @Date 2018/10/25 13:50
 * @Version 1.0
 */
public class RedisLock implements Lock {

    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;

    private int timeoutMsecs = 10 * 1000;

    private volatile boolean locked = false;

    public static void main(String[] args) {
        Lock lock = new RedisLock();
        lock.unlock();
    }

    @Override
    public void lock() {
        Jedis jedis = new Jedis("localhost", 6380);
        jedis.connect();
        long ok = jedis.setnx("lock", "lock");
        jedis.disconnect();
        if (ok == 1) {
            return;
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Jedis jedis = new Jedis("localhost", 6380);
        jedis.connect();
        long result = jedis.del("lock");
        jedis.disconnect();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
