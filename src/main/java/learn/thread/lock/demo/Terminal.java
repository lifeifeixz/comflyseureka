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

/**
 * @author flysLi
 * @ClassName Terminal
 * @Decription TODO
 * @Date 2019/1/21 13:54
 * @Version 1.0
 */
public class Terminal implements Runnable {
    private TickeSys tickeSys;

    public Terminal(TickeSys sys) {
        this.tickeSys = sys;
    }

    @Override
    public void run() {
        String ticket = tickeSys.buy();
        System.out.println(ticket);
    }
}
