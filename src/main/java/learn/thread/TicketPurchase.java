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

import java.util.LinkedList;

/**
 * @author flysLi
 * @ClassName TicketPurchase
 * @Decription TODO
 * @Date 2018/12/7 10:39
 * @Version 1.0
 */
public class TicketPurchase implements Runnable {
    private LinkedList<String> tickets;

    public TicketPurchase() {
        tickets = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            tickets.add("徐州~上海 K00" + i);
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 进入系统...");
        try {
            Thread.sleep(1000);
            String ticket = this.tickets.removeFirst();
            System.out.println(Thread.currentThread().getName() + " 购票完成[" + ticket + "]!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
