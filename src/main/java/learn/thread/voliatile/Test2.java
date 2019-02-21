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
package thread.voliatile;

/**
 * @author flysLi
 * @ClassName Test2
 * @Decription TODO
 * @Date 2018/10/25 11:27
 * @Version 1.0
 */
public class Test2 {
    private volatile boolean falg = false;

    public static void main(String[] args) throws InterruptedException {
        Plus1 plus1 = new Plus1();
        for (int i = 0; i < 11000; i++) {
            new Thread(() -> {
                plus1.i++;
            }).start();
        }
        Thread.sleep(10000);
        System.out.println("结果:" + plus1.i);
    }
}
