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
package thread.lock.demo;

import thread.lock.RedisLockV2;
import thread.lock.RedisLockV3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flysLi
 * @ClassName TickeSys
 * @Decription TODO
 * @Date 2019/1/21 13:49
 * @Version 1.0
 */
public class TickeSys {
    private List<String> tickets;

    public TickeSys(int ticketCount) {
        tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add("北京~广州K" + i);
        }
    }

    public String buy() {
        RedisLockV3 lock = new RedisLockV3();
        lock.lock("dmeo",3000);
//        synchronized (TickeSys.class) {
        if (tickets.size() > 0) {
            return tickets.remove(tickets.size() - 1);
        } else {
            System.out.println("没有票了");
        }
        lock.unlock();
//        }
        return null;
    }
}
