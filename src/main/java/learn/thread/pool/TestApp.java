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
package thread.pool;

import java.util.concurrent.*;

/**
 * @author flysLi
 * @ClassName TestApp
 * @Decription TODO
 * @Date 2019/1/22 10:01
 * @Version 1.0
 */
public class TestApp {
    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(10,
                20,
                20,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        service.execute(null);
    }
}
