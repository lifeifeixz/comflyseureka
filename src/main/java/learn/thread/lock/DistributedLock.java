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
package learn.thread.lock;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

/**
 * @author flysLi
 * @ClassName DistributedLock
 * @Decription TODO
 * @Date 2019/2/20 14:41
 * @Version 1.0
 */
public class DistributedLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试加锁
     *
     * @param jedis
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    public static boolean tryGetLock(Jedis jedis,
                                     String lockKey,
                                     String requestId,
                                     int expireTime) {
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public static void lock(String lockKey, String requestId) {
        Jedis jedis = new Jedis("localhost", 6379);
        int expireTime = 3000;
        while (true) {
            boolean res = tryGetLock(jedis, lockKey, requestId, expireTime);
            if (res) {
                break;
            }
        }
    }

    public static boolean unLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
