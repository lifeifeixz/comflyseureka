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

import java.util.concurrent.CompletableFuture;

/**
 * 在Java8中，CompletableFuture提供了非常强大的Future的扩展功能，
 * 可以帮助我们简化异步编程的复杂性，并且提供了函数式编程的能力，
 * 可以通过回调的方式处理计算结果，也提供了转换和组合 CompletableFuture 的方法。
 * 它可能代表一个明确完成的Future，也有可能代表一个完成阶段（ CompletionStage ），
 * 它支持在计算完成以后触发一些函数或执行某些动作。
 * 它实现了Future和CompletionStage接口
 *
 * @author flysLi
 * @ClassName CompletionStageTest
 * @Decription TODO
 * @Date 2018/10/30 10:32
 * @Version 1.0
 */
public class CompletionStageTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> i + 1)
                .thenApply(i -> i * i)
                .whenComplete((r, e) -> System.out.println("数据：" + r));

    }
}

class Test2 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + "World")
                .thenApply(String::toUpperCase);
    }
}