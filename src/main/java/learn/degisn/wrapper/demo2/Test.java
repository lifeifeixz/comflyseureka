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
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/12/14 10:48
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();

        //单层装饰
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);
        fish.move();
    }
}
