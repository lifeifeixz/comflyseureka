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
package learn.degisn.wrapper.demo2;

/**
 * @author flysLi
 * @ClassName Change
 * @Decription TODO
 * @Date 2018/12/14 10:46
 * @Version 1.0
 */
public class Change implements TheGreatestSage {
    private TheGreatestSage greatestSage;

    public Change(TheGreatestSage greatestSage) {
        this.greatestSage = greatestSage;
    }

    @Override
    public void move() {
        System.out.println("死猴子要变身了");
        greatestSage.move();
    }
}
