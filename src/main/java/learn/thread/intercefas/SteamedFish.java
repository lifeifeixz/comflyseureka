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
package thread.intercefas;

import java.util.ArrayList;

/**
 * @author flysLi
 * @ClassName SteamedFish
 * @Decription TODO
 * @Date 2018/10/22 11:01
 * @Version 1.0
 */
public class SteamedFish extends ArrayList implements Cook {

    @Override
    public Cook brushPot() {
        System.out.println("我自己刷锅");
        return this;
    }

    @Override
    public Cook cutUpVegetables() {
        System.out.println("切点葱花");
        return this;
    }

    @Override
    public Cook cooking() {
        System.out.println("大伙烧开，小火炖20分钟");
        return this;
    }

    @Override
    public Cook outPot() {
        System.out.println("出锅，撒点葱花，加点酱油。");
        return this;
    }
}
