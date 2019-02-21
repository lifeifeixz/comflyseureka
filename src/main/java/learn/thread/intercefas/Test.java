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

import thread.Download;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/22 11:00
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        Cook steamedFish = new SteamedFish();
//        steamedFish.brushPot()
//                .cutUpVegetables()
//                .cooking()
//                .outPot();

            //多线程
        FutureTask futureTask = new FutureTask(new Download());
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
