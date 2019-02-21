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
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/10/23 15:21
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread downloadPom = new Thread(new DownloadPom(latch));
        Thread generateConfig = new Thread(new GenerateIdeaConfig(latch));
        Thread writerCode = new Thread(new WriterCoding());

        downloadPom.start();
        generateConfig.start();
        latch.await();
        writerCode.start();


    }
}
