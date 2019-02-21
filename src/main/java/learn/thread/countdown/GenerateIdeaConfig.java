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
package thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author flysLi
 * @ClassName GenerateIdeaConfig
 * @Decription TODO
 * @Date 2018/10/23 15:19
 * @Version 1.0
 */
public class GenerateIdeaConfig implements Runnable {

    private CountDownLatch countDownLatch;

    public GenerateIdeaConfig(CountDownLatch downLatch) {
        this.countDownLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("生成idea配置文件");
        countDownLatch.countDown();
    }
}
