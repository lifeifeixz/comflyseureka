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
 * @ClassName RedisLockV2
 * @Decription TODO
 * @Date 2019/1/21 11:26
 * @Version 1.0
 */
public class RedisLockV2 {
    public static final String key = "lock";

    public static void main(String[] args) {

    }

    public void lock(long outTime) {
        Jedis jedis = new Jedis("localhost", 6380);
        //预算出超时的时间
        long futureTime = System.currentTimeMillis() + outTime;
        while (jedis.setnx(key, String.valueOf(futureTime)) == 0) {
            //计算是否超时
            futureTime = Long.valueOf(jedis.get("lock"));
            long now = System.currentTimeMillis();
            if (now > futureTime &&
                    now > Long.valueOf(jedis.getSet(key, String.valueOf(now + outTime)))) {
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        jedis.close();

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
