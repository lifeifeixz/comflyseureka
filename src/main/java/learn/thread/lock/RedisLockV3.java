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

/**
 * @author flysLi
 * @ClassName RedisLockV3
 * @Decription TODO
 * @Date 2019/1/21 14:53
 * @Version 1.0
 */
@SuppressWarnings("all")
public class RedisLockV3 {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    public static final String key = "lock";

    public static void main(String[] args) {

    }

    public void lock(String requestId, int expireTime) {
        while (!tryGetLock(requestId, expireTime)) {

        }
    }

    private boolean tryGetLock(String requestId, int expireTime) {
        Jedis jedis = new Jedis("localhost", 6380);
        String result = jedis.set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public void unlock() {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6380);
            jedis.del(key);
            jedis.close();
        } catch (Exception e) {
            jedis.close();
        }
    }
}
