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

import java.util.ArrayList;
import java.util.List;

/**
 * @author flysLi
 * @ClassName EDog
 * @Decription TODO
 * @Date 2018/10/9 9:39
 * @Version 1.0
 */
public class EDog implements Runnable {
    private int count = 1000;
    private List<Integer> tickets = new ArrayList<>(1000);

    public EDog() {
        for (int i = 1; i <= count; i++) {
            tickets.add(i);
        }
    }

    public Integer bug() {
        int ticket = tickets.get(tickets.get(0));
        try {
            tickets.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("票已没有了-----------------");
        }
        return ticket;
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getId() + "]进入系统");
        if (count > 0) {
            int sum = tickets.size();
            System.out.println("[" + Thread.currentThread().getId() + "查询是否还有余票:\t" + sum);
            if (sum < 1) {
                System.out.println("购票失败（无票）");
            }
            int ticket = bug();
            System.out.println("[" + Thread.currentThread().getId() + "]购票:\t" + ticket);
            System.out.println("[" + Thread.currentThread().getId() + "]交易完成");
        } else {
            throw new RuntimeException("购票失败");
        }

    }
}
