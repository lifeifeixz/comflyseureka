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
package thread.future.listenablefuture;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;


/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/29 15:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5, 5, 0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new CustomizableThreadFactory("demo"),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        /**
         * guava的接口ListeningExecutorService继承了jdk原生ExecutorService接口，
         * 重写了submit方法，修改返回值类型为ListenableFuture
         */
        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(poolExecutor);

        /**
         * 获得一个随着jvm关闭而关闭的线程池，通过Runtime.getRuntime().addShutdownHook(hook)实现
         * 修改ThreadFactory为创建守护线程，默认jvm关闭时最多等待120秒关闭线程池，重载方法可以设置时间
         */
        ExecutorService newpPoolExecutor = MoreExecutors.getExitingExecutorService(poolExecutor);

        /**
         * 只增加关闭线程池的钩子，不改变ThreadFactory
         */
        MoreExecutors.addDelayedShutdownHook(poolExecutor, 120, TimeUnit.SECONDS);

        //向线程池提交任务
        ListenableFuture<String> listenableFuture = listeningExecutor.submit(() -> "");

        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("成功的回调");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("失败的回调");
            }
        }, newpPoolExecutor);
        System.out.println("主流程结束");
    }
}

class Test2 {
    public static void main(String[] args) {
        ListenableFutureTask<String> task = ListenableFutureTask.create(() -> {
            String str = null;
            str.length();
            return "";
        });
        new Thread(task).start();
        task.addListener(() -> {
            System.out.println("task进入回调");
            ListenableFutureTask<String> task1 = ListenableFutureTask.create(() -> "");
            task1.addListener(() -> System.out.println("task1进入回调"), MoreExecutors.directExecutor());
            new Thread(task1).start();
        }, MoreExecutors.directExecutor());
    }
}
