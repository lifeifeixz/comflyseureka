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
package thread.future.demo2;

import netscape.security.UserTarget;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/29 14:58
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Callable<User> getUser = () -> {
            System.out.println("获取用户信息");
            return UserService.getUser();
        };

        //用户任务
        FutureTask userTask = new FutureTask(getUser);
        new Thread(userTask).start();

        //订单任务
        FutureTask<Order> orderTask = new FutureTask<>(() -> OrderService.getOrder());
        new Thread(orderTask).start();

        for (; ; ) {
            if (userTask.isDone() && orderTask.isDone()) {
                System.out.println("用户和订单执行完成！");
                break;
            }
        }
        System.out.println(userTask.get());
        System.out.println(orderTask.get());
        System.out.println("程序结束");
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }
}
