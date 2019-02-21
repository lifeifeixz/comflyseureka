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
 * @ClassName Fish
 * @Decription TODO
 * @Date 2018/12/14 10:47
 * @Version 1.0
 */
public class Fish extends Change {
    public Fish(TheGreatestSage greatestSage) {
        super(greatestSage);
    }

    @Override
    public void move() {
        System.out.println("鱼在游泳");
    }
}
