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
 * @ClassName Test
 * @Decription TODO
 * @Date 2019/1/21 13:56
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        ExecutorService executorService = new ThreadPoolExecutor(200,);
        TickeSys sys = new TickeSys(100);
        for (int i = 0; i < 101; i++) {
            new Thread(new Terminal(sys)).start();
        }

//        System.out.println("线程分配完毕!");
    }
}
