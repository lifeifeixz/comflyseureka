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
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/25 10:18
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        NumberRange range = new NumberRange();
        Thread tLower = new Thread(() -> {
            System.out.println("线程:" + Thread.currentThread().getName());
            range.setLower(4);
        });
        Thread tUpper = new Thread(() -> {
            System.out.println("线程:" + Thread.currentThread().getName());
            range.setUpper(3);
        });

        tLower.start();
        tUpper.start();
        System.out.println("程序结束");
        Thread.sleep(1000);
        System.out.println(range.toString());
    }
}
