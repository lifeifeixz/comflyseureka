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
 * @ClassName DownloadPom
 * @Decription TODO
 * @Date 2018/10/23 15:18
 * @Version 1.0
 */
public class DownloadPom implements Runnable {
    private CountDownLatch countDownLatch;

    public DownloadPom(CountDownLatch downLatch) {
        this.countDownLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("下载maven依赖");
        countDownLatch.countDown();
    }
}
