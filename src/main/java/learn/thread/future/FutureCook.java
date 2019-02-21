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
package thread.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author flysLi
 * @ClassName FutureCook
 * @Decription TODO
 * @Date 2018/10/29 11:04
 * @Version 1.0
 */
public class FutureCook {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        //第一步 网购厨具
        Callable<Chuju> onlineShopping = () -> {
            System.out.println("第一步：下单");
            System.out.println("第一步：等待送货");
            Thread.sleep(5000);//预计需要5秒中送达
            System.out.println("第一步：快递送到");
            return new Chuju();
        };
        FutureTask<Chuju> task = new FutureTask<>(onlineShopping);

        //第二步 去超市购买食材
        new Thread(task).start();
        Thread.sleep(2000);//买菜预计用时2秒钟
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");

        //第三步 用厨具烹饪食材
        if (!task.isDone()) {
            System.out.println("第三步：厨具还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
        }
        Chuju chuju = task.get();
        System.out.println("第三步：厨具到位，开始展现厨艺");
        cook(chuju, shicai);
        System.out.println("总共用时：" + (System.currentTimeMillis() - start) + "ms");

    }

    static void cook(Chuju chuju, Shicai shicai) {
    }
}
